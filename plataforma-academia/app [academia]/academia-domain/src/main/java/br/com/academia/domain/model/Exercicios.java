package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder

public class Exercicios {

    private int codigoExercicios;
    private int descricaoExercicios;
    private String status;
}
