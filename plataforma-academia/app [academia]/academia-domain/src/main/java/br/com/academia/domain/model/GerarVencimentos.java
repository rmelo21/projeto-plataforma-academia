package br.com.academia.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table  (name = "GerarVencimentos ")
public class GerarVencimentos {

    @Id
    @Column(name = "codigoGerarVencimentos")
    private int codigoGerarVencimentos;

    @Column(name = "valorGerarVencimentos")
    private BigDecimal valorGerarVencimentos;

    @Column(name = "valorMulta")
    private BigDecimal valorMulta;

    @Column(name = "jurosVencimento")
    private int jurosVencimento;

    @Column(name = "dataVencimento")
    private Date dataVencimento;

    @Column(name = "dataCadastroGerarVencimentos")
    private LocalDate dataCadastroGerarVencimentos;

    @Column(name = "STATUS")
    private String status;

}
