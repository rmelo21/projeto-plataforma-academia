package br.com.academia.application.model;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component


@Entity
@Table(name = "SERIESEXERCICIOS")
public class SeriesExercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_series_exercicios", nullable = false)
    private Integer codigoSeriesExercicios;

    @Column(name = "serie_repeticao", nullable = false, length = 3)
    private Integer serieRepeticao;

    @Column(name = "carga", nullable = false, length = 3)
    private Integer carga;

    @Column(name = "carga_maxima", length = 3)
    private Integer cargaMaxima;

    @Column(name = "observacao", length = 100)
    private String observacao;

    @Builder.Default
    @Column(name = "status", length = 1, nullable = false)
    private String status = "A";

}
