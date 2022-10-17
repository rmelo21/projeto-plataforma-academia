package br.com.academia.domain.model.interactions;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Data
@Builder

public class Matricula {

    private int codigo;
    private int codigo_aluno;
    private int codigo_modalidade;
    private BigDecimal valor_total;
    private int desconto;
    private LocalDate data_inicio;
    private LocalDate data_matricula;
    private LocalDate data_cancelamento;
    private String status;
    private String motivo_cancelamento;
}
