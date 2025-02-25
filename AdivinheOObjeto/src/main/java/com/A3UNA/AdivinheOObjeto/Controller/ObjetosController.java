package com.A3UNA.AdivinheOObjeto.Controller;

import com.A3UNA.AdivinheOObjeto.Objetos.Objeto;
import com.A3UNA.AdivinheOObjeto.Service.ObjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jogo")
public class ObjetosController {
    private ObjetoService service;
    public ObjetosController(ObjetoService service) {
        this.service = service;

    }
    @GetMapping("/dica")
    public Map<String, String> obterDica() {
        Objeto objeto = service.obterObjeto();
        Map<String, String> verificar = new HashMap<> ();
        verificar.put("Dica", objeto.getDica ());

        return verificar;
    }
    @PostMapping("/verificar")
    public Map<String, String> verificarObjeto (@RequestParam String resposta, @RequestParam String nomeObejto) {
        boolean respostaCorreta = service.verificarResporta ( resposta, nomeObejto );
        Map<String, String> verificar = new HashMap<> ();
        verificar.put("Resultado", respostaCorreta ? "Parabéns! Você acertou!" : "Tente novamente!");
        return verificar;
    }
}
