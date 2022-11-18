package br.com.academia.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "MATRICULA")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_matricula", nullable = false)
    private Long codigoMatricula;

    @Column(name = "valor_total_matricula", nullable = false, length = 10, precision = 2)
    private BigDecimal valorTotalMatricula;

    @Column(name = "desconto_matricula", length = 10)
    private Integer descontoMatricula;

    @Column(name = "data_inicio_matricula")
    private LocalDate dataInicioMatricula;

    @Column(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula;

    @Column(name = "data_cancelamento_matricula")
    private LocalDate dataCancelamentoMatricula;

    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @Column(name = "motivo_cancelamento_matricula", length = 100)
    private String motivoCancelamentoMatricula;

}
