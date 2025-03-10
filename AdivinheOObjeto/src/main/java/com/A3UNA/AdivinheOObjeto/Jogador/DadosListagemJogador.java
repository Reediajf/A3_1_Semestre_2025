package com.A3UNA.AdivinheOObjeto.Jogador;

public record DadosListagemJogador(Long id, String nome, int pontuacao) {

    public DadosListagemJogador(Jogador jogador) {
        this(jogador.getId (), jogador.getNome (), jogador.getPontuacao ());
    }

}
