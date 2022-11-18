package br.com.academia.application.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component


@Entity
@Table(name = "GERARVENCIMENTOS")
public class GerarVencimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_gerar_vencimentos", nullable = false)
    private Integer codigoGerarVencimentos;

    @Column(name = "valor_gerar_vencimentos", nullable = false, length = 10, precision = 2)
    private BigDecimal valorGerarVencimentos;

    @Column(name = "valor_multa", nullable = false, length = 10, precision = 2)
    private BigDecimal valorMulta;

    @Column(name = "juros_vencimento", nullable = false, length = 2)
    private Integer jurosVencimento;

    @Column(name = "data_vencimento", nullable = false)
    private Date dataVencimento;

    @Column(name = "data_cadastro_gerar_vencimentos", nullable = false)
    private LocalDate dataCadastroGerarVencimentos = LocalDate.now();

    @Column(name = "status", length = 1, nullable = false)
    private String status;

}
