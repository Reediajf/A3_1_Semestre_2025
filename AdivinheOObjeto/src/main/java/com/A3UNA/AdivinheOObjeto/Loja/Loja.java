package com.A3UNA.AdivinheOObjeto.Loja;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "loja")
@Entity(name = "Loja")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int valor;
    private String descricao;


}
