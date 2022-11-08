package br.com.academia.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity@Table(name = "MATRICULA")
public class Matricula {

    @Id
    @Column(name = "codigoMatricula")
    private int codigoMatricula;

    @Column(name = "valorTotalMatricula")
    private BigDecimal valorTotalMatricula;

    @Column(name = "descontoMatricula")
    private int descontoMatricula;

    @Column(name = "dataInicioMatricula")
    private LocalDate dataInicioMatricula;

    @Column(name = " dataMatricula")
    private LocalDate dataMatricula;

    @Column(name = "dataCancelamentoMatricula")
    private LocalDate dataCancelamentoMatricula;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "motivoCancelamentoMatricula")
    private String motivoCancelamentoMatricula;

}
