package br.com.academia.application.model;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component


@Entity
@Table(name = "MODALIDADEHORARIO")
public class ModalidadeHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_modalidade_horario", nullable = false)
    private Integer codigoModalidadeHorario;

    @Column(name = "dia_semana_modalidade_horario", length = 100)
    private String diaSemanaModalidadeHorario;

    @Column(name = "hora_inicio_modalidade_horario")
    private Time horaInicioModalidadeHorario;

    @Column(name = "hora_fim_modalidade_horario")
    private Time horaFimModalidadeHorario;

    @Builder.Default
    @Column(name = "data_cadastro_modalidade_horario")
    private LocalDate dataCadastroModalidadeHorario = LocalDate.now();

    @Builder.Default
    @Column(name = "status", length = 1, nullable = false)
    private String status = "A";

}
