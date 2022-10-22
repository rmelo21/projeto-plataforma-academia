package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Data
@Builder

public class GerarVencimentos {

    private int codigoGerarVencimentos;
    private BigDecimal valorGerarVencimentos;
    private BigDecimal valorMulta;
    private int jurosVencimento;
    private Date dataVencimento;
    private LocalDate dataCadastroGerarVencimentos;
    private String status;

}
