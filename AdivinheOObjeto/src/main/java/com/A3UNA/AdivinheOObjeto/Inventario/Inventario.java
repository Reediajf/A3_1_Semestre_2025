package com.A3UNA.AdivinheOObjeto.Inventario;

import com.A3UNA.AdivinheOObjeto.Jogador.Jogador;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "inventario")
@Entity(name = "Inventario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "jogador_id", nullable = false)
    private Jogador jogador;

    public Inventario(Jogador jogador, int quantidade) {
        this.jogador = jogador;
        this.quantidade = quantidade;
    }

}
