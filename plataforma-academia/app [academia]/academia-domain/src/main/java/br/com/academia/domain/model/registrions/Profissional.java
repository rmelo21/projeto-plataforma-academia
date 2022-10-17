package br.com.academia.domain.model.registrions;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
@Builder

public class Profissional {
    private int codigo;
    private String cargo;
    private String escolaridade;
    private LocalDate data_cadastro;
    private LocalDate data_admissao;
    private LocalDate data_demissao;
    private String status;
}
