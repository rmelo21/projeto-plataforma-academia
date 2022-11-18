package br.com.academia.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PROFISSIONAL")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_profissional", nullable = false)
    private Long codigoProfissional;

    @Column(name = "cargo", nullable = false, length = 40)
    private String cargo;

    @Column(name = "escolaridade", nullable = false, length = 40)
    private String escolaridade;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @Column(name = "data_demissao")
    private LocalDate dataDemissao;

    @Column(name = "status", nullable = false, length = 1)
    private String status;
}
