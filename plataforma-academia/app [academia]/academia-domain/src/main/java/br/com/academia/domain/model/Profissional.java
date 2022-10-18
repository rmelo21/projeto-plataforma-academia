package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
@Builder

public class Profissional {

    private int codigoProfissional;
    private String cargo;
    private String escolaridade;
    private LocalDate dataCadastro;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private String status;
}
