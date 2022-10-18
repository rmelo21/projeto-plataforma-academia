package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Data
@Builder

public class Matricula {

    private int codigoMatricula;
    private BigDecimal valorTotal;
    private int desconto;
    private LocalDate dataInicio;
    private LocalDate dataMatricula;
    private LocalDate dataCancelamento;
    private String status;
    private String motivoCancelamento;
    private String status;
}
