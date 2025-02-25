package com.A3UNA.AdivinheOObjeto.Service;


import com.A3UNA.AdivinheOObjeto.Objetos.Objeto;
import com.A3UNA.AdivinheOObjeto.Repository.ObjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ObjetoService {
    private final ObjetoRepository repository;
    private final Random random = new Random ();

    public ObjetoService ( ObjetoRepository repository ) {
        this.repository = repository;
    }


    public Objeto obterObjeto () {
        List<Objeto> objetos = repository.findAll();
        if (objetos.isEmpty ()) {
            throw new RuntimeException ("Nenhum objeto encontrado");
        }
        return objetos.get (random.nextInt (objetos.size ()));
    }

    public boolean verificarResporta(String resposta, String nomeObjeto) {
        return resposta.equalsIgnoreCase (nomeObjeto);
    }

}
