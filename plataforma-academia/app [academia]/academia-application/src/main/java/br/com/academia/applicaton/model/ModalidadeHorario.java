package br.com.academia.applicaton.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "ModalidadeHorario")
public class ModalidadeHorario {

    @Id
    @Column(name = "codigoModalidadeHorario")
    private int codigoModalidadeHorario;

    @Column(name = "diaSemanaModalidadeHorario")
    private String diaSemanaModalidadeHorario;

    @Column(name = "horaInicioModalidadeHorarioO")
    private Time horaInicioModalidadeHorario;

    @Column(name = "horaFimModalidadeHorario")
    private Time horaFimModalidadeHorario;

    @Column(name = "dataCadastroModalidadeHorario")
    private LocalDate dataCadastroModalidadeHorario;

    @Column(name = "STATUS")
    private String status;

}
