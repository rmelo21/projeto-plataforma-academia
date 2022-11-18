package br.com.academia.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "MODALIDADE")
public class Modalidade {

    @Id
    @Column(name = "codigo_modalidade", nullable = false)
    private Long codigoModalidade;

    @Column(name = "nome_modalidade", nullable = false, length = 40)
    private String nomeModalidade;

    @Column(name = "descricao_modalidade", nullable = false, length = 100)
    private String descricaoModalidade;

    @Column(name = "valor_modalidade", nullable = false, length = 10, precision = 2)
    private BigDecimal valorModalidade;

    @Column(name = "data_cadastro_modalidade", nullable = false)
    private LocalDate dataCadastroModalidade;

    @Column(name = "status", nullable = false, length = 1)
    private String status;

}
