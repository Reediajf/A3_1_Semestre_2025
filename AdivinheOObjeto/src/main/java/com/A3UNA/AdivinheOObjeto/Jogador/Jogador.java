package com.A3UNA.AdivinheOObjeto.Jogador;

import jakarta.persistence.*;
import lombok.*;

@Table (name = "jogador")
@Entity (name = "Jogador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Jogador {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int pontuacao = 0;

    public Jogador ( DadosCadastroJogador dados ) {
        this.nome = dados.nome();
    }

    public Jogador ( String nome, int pontuacao ) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }


}


