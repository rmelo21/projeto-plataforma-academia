package br.com.academia.domain.model.registrions;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
@Builder

public class Pessoa {
    private int codigo;
    private int codigo_endereco;
    private int codigo_telefone;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private LocalDate data_nascimento;
    private LocalDate data_cadastro;
    private String status;

}
