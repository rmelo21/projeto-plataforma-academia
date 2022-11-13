package br.com.academia.applicaton.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGOALUNO")
    private Integer codigoAluno;

    @Column(name = "NOME", length = 100)
    private String nome;

}

