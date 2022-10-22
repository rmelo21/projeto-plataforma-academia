package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Data
@Builder

public class Modalidade {

    private int codigoModalidade;
    private String nomeModalidade;
    private String descricaoModalidade;
    private BigDecimal valorModalidade;
    private LocalDate dataCadastroModalidade;
    private String status;

}
