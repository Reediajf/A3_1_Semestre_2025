package com.A3UNA.AdivinheOObjeto.Controller;

import com.A3UNA.AdivinheOObjeto.Objetos.Objeto;
import com.A3UNA.AdivinheOObjeto.Service.ObjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping ( "/jogo" )
public class ObjetosController {
    private ObjetoService service;
    private int contadorDica = 0;

    public ObjetosController ( ObjetoService service ) {
        this.service = service;
    }

    @GetMapping ( "/dica" )
    public Map<String, String> obterDica () {
        Objeto objeto = service.obterObjeto ();
        Map<String, String> verificar = new HashMap<> ();
        switch (contadorDica) {
            case 0:
                verificar.put ( "Dica", objeto.getDica () );
                contadorDica++;
                break;
            case 1:
                verificar.put ( "Dica", objeto.getDica2 () );
                contadorDica++;
                break;
            case 2:
                verificar.put ( "Dica", objeto.getDica3 () );
                contadorDica++;
                break;
            default:
                verificar.put ( "Dica", "Você já usou todas as dicas!" );
                break;
        }

        return verificar;
    }

    @PostMapping ( "/verificar" )
    public Map<String, String> verificarObjeto ( @RequestParam String resposta, @RequestParam String nomeObejto ) {
        boolean respostaCorreta = service.verificarResposta ( resposta, nomeObejto );
        Map<String, String> verificar = new HashMap<> ();
        verificar.put ( "Resultado", respostaCorreta ? "Parabéns! Você acertou!" : "Tente novamente!" );
        if (!respostaCorreta) {
            verificar.put ( "Resposta correta", resposta );
            verificar.putAll ( obterDica () );
        }
        return verificar;
    }
}