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
@Table(name = "FICHAAVALIACAO")

public class FichaAvaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_ficha_avalilacao", nullable = false)
    private Long codigoFichaAvalilacao;

    @Column(name = "peso", nullable = false, length = 3, precision = 4)
    private BigDecimal peso;

    @Column(name = "altura", nullable = false, length = 1, precision = 3)
    private BigDecimal altura;

    @Column(name = "peito", length = 2, precision = 3)
    private BigDecimal peito;

    @Column(name = "cintura", length = 2, precision = 3)
    private BigDecimal cintura;

    @Column(name = "quadril", length = 2, precision = 3)
    private BigDecimal quadril;

    @Column(name = "braco_dreito", length = 2, precision = 3)
    private BigDecimal bracoDireito;

    @Column(name = "braco_esquerdo", length = 2, precision = 3)
    private BigDecimal bracoEsquerdo;

    @Column(name = "coxa_direita", length = 2, precision = 3)
    private BigDecimal coxaDireita;

    @Column(name = "coxa_esquerda", length = 2, precision = 3)
    private BigDecimal coxaEsquerda;

    @Column(name = "gemeos_direito", length = 2, precision = 3)
    private BigDecimal gemeosDireito;

    @Column(name = "gemoes_esquerdo", length = 2, precision = 3)
    private BigDecimal gemoesEsquerdo;

    @Column(name = "antebraco_direito", length = 2, precision = 3)
    private BigDecimal antebracoDireito;

    @Column(name = "antebraco_esquerdo", length = 2, precision = 3)
    private BigDecimal antebracoEsquerdo;

    @Column(name = "abdomen", length = 2, precision = 3)
    private BigDecimal abdomen;

    @Column(name = "dobra_cutanea", length = 2, precision = 3)
    private BigDecimal dobraCutanea;

    @Column(name = "IMC", length = 3, precision = 3)
    private BigDecimal imc;

    @Column(name = "hipertrofia", length = 2, precision = 3)
    private String hipertrofia;

    @Column(name = "condicional", length = 2, precision = 3)
    private String condicional;

    @Column(name = "definicao", length = 2, precision = 3)
    private String definicao;

    @Column(name = "reducao", length = 2, precision = 3)
    private String reducao;

    @Column(name = "descricao_objetivo", length = 2, precision = 3)
    private String descricaoObjetivo;

    @Column(name = "anotacoes_gerais_ficha_avaliacao", nullable = false, length = 100)
    private String anotacoesGeraisFichaAvaliacao;

    @Column(name = "data_cadastro_ficha_avaliacao", nullable = false)
    private LocalDate dataCadastroFichaAvaliacao;

}
