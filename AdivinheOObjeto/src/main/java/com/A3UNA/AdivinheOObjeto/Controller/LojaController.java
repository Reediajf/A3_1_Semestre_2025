package com.A3UNA.AdivinheOObjeto.Controller;

import com.A3UNA.AdivinheOObjeto.Inventario.InventarioService;
import com.A3UNA.AdivinheOObjeto.Jogador.Jogador;
import com.A3UNA.AdivinheOObjeto.Jogador.JogadorRepository;
import com.A3UNA.AdivinheOObjeto.Loja.Loja;
import com.A3UNA.AdivinheOObjeto.Loja.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public Page<Loja> listarItensLoja(@RequestParam(defaultValue = "0") int page) {
        return lojaRepository.findAll(PageRequest.of(page, 10));
    }

    @PostMapping("/comprar/{jogadorId}/{itemId}")
    @Transactional
    public String comprarItem(@PathVariable Long jogadorId, @PathVariable Long itemId) {
        Optional<Jogador> jogadorOpt = jogadorRepository.findById(jogadorId);
        Optional<Loja> itemOpt = lojaRepository.findById(itemId);

        if (jogadorOpt.isEmpty()) {
            return "Jogador não encontrado!";
        }
        if (itemOpt.isEmpty()) {
            return "Item não encontrado na loja!";
        }

        Jogador jogador = jogadorOpt.get();
        Loja item = itemOpt.get();

        if (jogador.getPontuacao() < item.getValor()) {
            return "Pontuação insuficiente para comprar " + item.getNome();
        }

        jogador.setPontuacao(jogador.getPontuacao() - item.getValor());
        jogadorRepository.save(jogador);

        inventarioService.adicionarItemAoInventario(jogador.getId(), 1);

        return "Item comprado com sucesso: " + item.getNome();
    }
}
