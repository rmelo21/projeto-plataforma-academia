package br.com.academia.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "ALUNO")
public class Aluno {

    @Id
    @Column(name = "CODIGO")
    private Integer codigoAluno;

    @Column(name = "NOME")
    private String nome;

}
