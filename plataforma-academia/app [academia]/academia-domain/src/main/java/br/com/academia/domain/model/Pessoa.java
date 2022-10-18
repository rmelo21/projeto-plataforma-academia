package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
@Builder

public class Pessoa {
    private int codigoPessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String status;

}
