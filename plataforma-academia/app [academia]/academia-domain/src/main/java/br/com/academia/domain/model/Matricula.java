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
    private BigDecimal valorTotalMatricula;
    private int descontoMatricula;
    private LocalDate dataInicioMatricula;
    private LocalDate dataMatricula;
    private LocalDate dataCancelamentoMatricula;
    private String status;
    private String motivoCancelamentoMatricula;

}
