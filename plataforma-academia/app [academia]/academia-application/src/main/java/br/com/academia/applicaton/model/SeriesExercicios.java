package br.com.academia.applicaton.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "SeriesExercicios")
public class SeriesExercicios {

    @Id
    @Column(name = "codigoSeriesExercicios")
    private int codigoSeriesExercicios;

    @Column(name = "serieRepeticao")
    private int serieRepeticao;

    @Column(name = "CARGA")
    private int carga;

    @Column(name = "cargaMaxima")
    private int cargaMaxima;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "STATUS")
    private String status;

}
