package com.A3UNA.AdivinheOObjeto.Controller;

import com.A3UNA.AdivinheOObjeto.Jogador.DadosListagemJogador;
import com.A3UNA.AdivinheOObjeto.Jogador.Jogador;
import com.A3UNA.AdivinheOObjeto.Jogador.JogadorRepository;
import com.A3UNA.AdivinheOObjeto.Objeto.DadosListagemObjeto;
import com.A3UNA.AdivinheOObjeto.Objeto.Objeto;
import com.A3UNA.AdivinheOObjeto.Objeto.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    private DadosListagemObjeto objetoSelecionado;
    private int numeroDicasUsadas = 0;

    @Autowired
    private ObjetoRepository objetoRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    private Jogador jogador;

    private DadosListagemObjeto objetoExplicacao;

    private static final String ACERTOU = "Parabéns! Você acertou!";
    private static final String ERROU = "Tente novamente!";
    private static final String ERRO_JOGO_NAO_INICIADO = "Nenhum objeto foi selecionado. Inicie o jogo primeiro!";
    private static final String ERRO_NOME_JOGADOR = "Nome do jogador não pode ser vazio.";

    @GetMapping("/iniciar")
    public ResponseEntity<String> iniciar(@RequestParam String nomeJogador) {
        if (nomeJogador == null || nomeJogador.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(ERRO_NOME_JOGADOR);
        }

        List<Objeto> objetos = objetoRepository.findAll();
        List<DadosListagemObjeto> listaObjetos = objetos.stream()
                .map(DadosListagemObjeto::new)
                .collect(Collectors.toList());

        if (listaObjetos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum objeto encontrado no banco de dados!");
        }

        objetoSelecionado = DadosListagemObjeto.ObjetoAleatorio(listaObjetos);
        System.out.println(objetoSelecionado);
        numeroDicasUsadas = 0;

        Optional<Jogador> jogadorExistente = jogadorRepository.findByNome(nomeJogador);

        jogador = jogadorExistente.orElseGet(() -> {
            Jogador novoJogador = new Jogador(nomeJogador, 0);
            jogadorRepository.save(novoJogador);
            return novoJogador;
        });

        return ResponseEntity.ok("Jogo iniciado! Adivinhe o objeto.");
    }

    private boolean verificarResposta(String resposta, String nomeObjeto) {
        return resposta.equalsIgnoreCase(nomeObjeto);
    }

    @GetMapping("/dica")
    public ResponseEntity<Map<String, String>> obterDica() {
        Map<String, String> resposta = new HashMap<>();

        if (objetoSelecionado == null) {
            resposta.put("Erro", ERRO_JOGO_NAO_INICIADO);
            return ResponseEntity.badRequest().body(resposta);
        }

        String dica;
        int pontos;

        switch (numeroDicasUsadas) {
            case 0 -> {
                dica = objetoSelecionado.dica();
                pontos = 20;
            }
            case 1 -> {
                dica = objetoSelecionado.dica2();
                pontos = 10;
            }
            case 2 -> {
                dica = objetoSelecionado.dica3();
                pontos = 5;
            }
            default -> {
                resposta.put("Dica", "Você já usou todas as dicas!");
                return ResponseEntity.ok(resposta);
            }
        }

        numeroDicasUsadas++;
        resposta.put("Dica", dica);

        if (jogador != null) {
            jogador.setPontuacao(jogador.getPontuacao() + pontos);
            jogadorRepository.save(jogador);
        }

        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/verificar")
    public ResponseEntity<Map<String, String>> verificarObjeto(@RequestParam String resposta) {
        Map<String, String> verificar = new HashMap<>();

        if (objetoSelecionado == null) {
            verificar.put("Erro", ERRO_JOGO_NAO_INICIADO);
            return ResponseEntity.badRequest().body(verificar);
        }

        boolean respostaCorreta = verificarResposta(resposta, objetoSelecionado.nome());
        verificar.put("Resultado", respostaCorreta ? ACERTOU : ERROU);

        if (respostaCorreta) {
            objetoExplicacao = objetoSelecionado ;
            reiniciar();

        } else {
            verificar.put("Dica", "Se precisar, solicite uma dica");
        }

        return ResponseEntity.ok(verificar);
    }

    private void reiniciar() {
        numeroDicasUsadas = 0;
        List<Objeto> objetos = objetoRepository.findAll();
        List<DadosListagemObjeto> listaObjetos = objetos.stream()
                .map(DadosListagemObjeto::new)
                .collect(Collectors.toList());

        if (!listaObjetos.isEmpty()) {
            objetoSelecionado = DadosListagemObjeto.ObjetoAleatorio(listaObjetos);
        }
    }

    @GetMapping("/explicacao")
    public String explicacao() {
        if (objetoExplicacao == null) {
            return "Nenhum objeto selecionado";
        }

         return objetoExplicacao.toString();
    }

    @GetMapping("/jogadores")
    public ResponseEntity<Page<DadosListagemJogador>> listarJogadores(
            @PageableDefault(size = 10, sort = "pontuacao", direction = Sort.Direction.DESC) Pageable paginacao) {

        Page<DadosListagemJogador> jogadores = jogadorRepository.findAll(paginacao).map(DadosListagemJogador::new);

        if (jogadores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(jogadores);
    }
}
