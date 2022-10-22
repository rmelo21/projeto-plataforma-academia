package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
@Builder

public class Aluno {

    private int codigoAluno;
    private String nomeResponsavel;
    private LocalDate dataCadastroAluno;
    private String status;

}
