package br.com.academia.application.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component


@Entity
@Table(name = "ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_aluno", nullable = false)
    private Integer codigoAluno;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

}

