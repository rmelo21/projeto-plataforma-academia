package br.com.academia.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @Column(name = "codigoPessoa")
    private int codigoPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPD")
    private String cpf;

    @Column(name = "RG")
    private String rg;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "dataCadastro")
    private LocalDate dataCadastro;

    @Column(name = "STATUS")
    private String status;

}
