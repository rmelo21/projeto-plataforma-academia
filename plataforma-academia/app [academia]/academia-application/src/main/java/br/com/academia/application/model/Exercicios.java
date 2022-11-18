package br.com.academia.application.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "EXERCICIOS")
public class Exercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_exercicios", nullable = false)
    private Long codigoExercicios;

    @Column(name = "descricao_exercicios", length = 40, nullable = false)
    private Integer descricaoExercicios;

    @Column(name = "status", length = 1, nullable = false)
    private String status;
}
