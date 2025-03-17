package com.A3UNA.AdivinheOObjeto.Controller;

import com.A3UNA.AdivinheOObjeto.Inventario.Inventario;
import com.A3UNA.AdivinheOObjeto.Inventario.InventarioRepository;
import com.A3UNA.AdivinheOObjeto.Jogador.Jogador;
import com.A3UNA.AdivinheOObjeto.Jogador.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InventarioController {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @Transactional
    public String adicionarItemAoInventario(Long jogadorId, int quantidade) {
        Optional<Jogador> jogadorOpt = jogadorRepository.findById(jogadorId);

        if (jogadorOpt.isPresent()) {
            Jogador jogador = jogadorOpt.get();

            Inventario novoItem = new Inventario(jogador, quantidade);
            inventarioRepository.save(novoItem);

            return "Item adicionado ao inventário!";
        }
        return "Jogador não encontrado!";
    }
    public List<Inventario> listarInventario(Long jogadorId) {
        return inventarioRepository.findByJogadorId(jogadorId);
    }
}
