package br.com.academia.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.beans.ConstructorProperties;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

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
