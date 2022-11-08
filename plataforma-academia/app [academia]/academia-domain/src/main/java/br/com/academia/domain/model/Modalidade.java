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

@Entity
@Table(name = "Modalidade")
public class Modalidade {

    @Id
    @Column(name = "codigoModalidade")
    private int codigoModalidade;

    @Column(name = "nomeModalidade")
    private String nomeModalidade;

    @Column(name = "descricaoModalidade")
    private String descricaoModalidade;

    @Column(name = "valorModalidade")
    private BigDecimal valorModalidade;

    @Column(name = "dataCadastroModalidade")
    private LocalDate dataCadastroModalidade;

    @Column(name = "STATUS")
    private String status;

}
