package br.com.academia.application.model;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component


@Entity
@Table(name = "MATRICULA")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_matricula", nullable = false)
    private Integer codigoMatricula;

    @Column(name = "valor_total_matricula", nullable = false, length = 10, precision = 2)
    private BigDecimal valorTotalMatricula;

    @Column(name = "desconto_matricula", length = 10)
    private Integer descontoMatricula;

    @Column(name = "data_inicio_matricula")
    private LocalDate dataInicioMatricula;

    @Builder.Default
    @Column(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula = LocalDate.now();

    @Column(name = "data_cancelamento_matricula")
    private LocalDate dataCancelamentoMatricula;

    @Column(name = "motivo_cancelamento_matricula", length = 100)
    private String motivoCancelamentoMatricula;

    @Builder.Default
    @Column(name = "status", length = 1, nullable = false)
    private String status = "A";

}
