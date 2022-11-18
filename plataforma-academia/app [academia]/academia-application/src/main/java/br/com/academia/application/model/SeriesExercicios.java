package br.com.academia.application.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

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

    @Column(name = "status", nullable = false, length = 1)
    private String status;

}
