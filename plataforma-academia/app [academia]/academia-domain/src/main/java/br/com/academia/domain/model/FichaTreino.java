package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
@Builder

public class FichaTreino {

    private int codigoFichaTreino;
    private int numeroFicha;
    private LocalDate dataCadastroFichaTreino;
    private String anotacoesGeraisFichaTreino;

}
