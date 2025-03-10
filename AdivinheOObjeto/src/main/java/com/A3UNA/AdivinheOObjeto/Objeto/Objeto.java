package com.A3UNA.AdivinheOObjeto.Objeto;
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
    private String dica2;
    private String dica3;
    private String categoria;
 }



