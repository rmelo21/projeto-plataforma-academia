package br.com.academia.application.model;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component


@Entity
@Table(name = "FICHAAVALIACAO")

public class FichaAvaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_ficha_avalilacao", nullable = false)
    private Integer codigoFichaAvalilacao;

    //TODO USANDO BIGDECIMAL AO PESQUISAR CADASTRO SALVO APRESENTA ERRO NO CONSOLE DO INTELLIJ (VALOR INVALIDO)
    @Column(name = "peso", nullable = false, length = 3, precision = 4)
    private double peso;

    @Column(name = "altura", nullable = false, length = 1, precision = 3)
    private double altura;

    @Column(name = "peito", length = 2, precision = 3)
    private double peito;

    @Column(name = "cintura", length = 2, precision = 3)
    private double cintura;

    @Column(name = "quadril", length = 2, precision = 3)
    private double quadril;

    @Column(name = "braco_dreito", length = 2, precision = 3)
    private double bracoDireito;

    @Column(name = "braco_esquerdo", length = 2, precision = 3)
    private double bracoEsquerdo;

    @Column(name = "coxa_direita", length = 2, precision = 3)
    private double coxaDireita;

    @Column(name = "coxa_esquerda", length = 2, precision = 3)
    private double coxaEsquerda;

    @Column(name = "gemeos_direito", length = 2, precision = 3)
    private double gemeosDireito;

    @Column(name = "gemoes_esquerdo", length = 2, precision = 3)
    private double gemoesEsquerdo;

    @Column(name = "antebraco_direito", length = 2, precision = 3)
    private double antebracoDireito;

    @Column(name = "antebraco_esquerdo", length = 2, precision = 3)
    private double antebracoEsquerdo;

    @Column(name = "abdomen", length = 2, precision = 3)
    private double abdomen;

    @Column(name = "dobra_cutanea", length = 2, precision = 3)
    private double dobraCutanea;

    @Column(name = "IMC", length = 3, precision = 3)
    private double imc;

    @Column(name = "hipertrofia", length = 1)
    private String hipertrofia;

    @Column(name = "condicional", length = 1)
    private String condicional;

    @Column(name = "definicao", length = 1)
    private String definicao;

    @Column(name = "reducao", length = 1)
    private String reducao;

    @Column(name = "descricao_objetivo", length = 100)
    private String descricaoObjetivo;

    @Column(name = "anotacoes_gerais_ficha_avaliacao", nullable = false, length = 100)
    private String anotacoesGeraisFichaAvaliacao;

    @Builder.Default
    @Column(name = "data_cadastro_ficha_avaliacao", nullable = false)
    private LocalDate dataCadastroFichaAvaliacao = LocalDate.now();

}
