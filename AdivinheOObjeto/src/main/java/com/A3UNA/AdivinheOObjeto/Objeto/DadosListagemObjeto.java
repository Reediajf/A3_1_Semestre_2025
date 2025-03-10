package com.A3UNA.AdivinheOObjeto.Objeto;


import java.util.List;
import java.util.Random;

public record DadosListagemObjeto(Long id,
                                  String nome,
                                  String dica,
                                  String dica2,
                                  String dica3,
                                  String categoria) {



    public DadosListagemObjeto(Objeto objeto) {
        this( objeto.getId (), objeto.getNome (), objeto.getDica (), objeto.getDica2 (), objeto.getDica3 (), objeto.getCategoria ());
    }

    public static DadosListagemObjeto ObjetoAleatorio( List<DadosListagemObjeto> lista) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista.size());
        return lista.get(indiceAleatorio);
    }

}
