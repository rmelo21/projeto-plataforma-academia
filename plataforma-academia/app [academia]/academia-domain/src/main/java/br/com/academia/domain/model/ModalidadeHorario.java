package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Data
@Builder

public class ModalidadeHorario {

    private int codigoModalidadeHorario;
    private String diaSemanaModalidadeHorario;
    private Time horaInicioModalidadeHorario;
    private Time horaFimModalidadeHorario;
    private LocalDate dataCadastroModalidadeHorario;
    private String status;

}
