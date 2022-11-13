package br.com.academia.applicaton.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "PROFISSIONAL")
public class Profissional {

    @Id
    @Column(name = "codigoProfissional")
    private int codigoProfissional;

    @Column(name = "CARGO")
    private String cargo;

    @Column(name = "ESCOLARIDADE")
    private String escolaridade;

    @Column(name = "dataCadastro")
    private LocalDate dataCadastro;

    @Column(name = "dataAdmissao")
    private LocalDate dataAdmissao;

    @Column(name = "dataDemissao")
    private LocalDate dataDemissao;

    @Column(name = "STATUS")
    private String status;
}
