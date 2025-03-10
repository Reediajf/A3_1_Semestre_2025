package com.A3UNA.AdivinheOObjeto.Controller;

import com.A3UNA.AdivinheOObjeto.Jogador.DadosCadastroJogador;
import com.A3UNA.AdivinheOObjeto.Jogador.Jogador;
import com.A3UNA.AdivinheOObjeto.Jogador.JogadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    private JogadorRepository repository;


    @PostMapping
    @Transactional
    public void CadastrarJogador(@RequestBody @Valid DadosCadastroJogador dados) {
        repository.save(new Jogador (dados));
    }




}
