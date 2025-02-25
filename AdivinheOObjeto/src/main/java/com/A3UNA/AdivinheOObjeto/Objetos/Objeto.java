package com.A3UNA.AdivinheOObjeto.Objetos;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "objetos")
@Entity(name = "Objeto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Objeto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dica;

 }



