package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Data
@Builder

@Entity
@Table(name = "FichaAvaliacao")
@NoArgsConstructor
public class FichaAvaliacao {

    @Id
    @Column(name = "codigoFichaAvaliacaoO")
    private int codigoFichaAvaliacao;

    @Column(name = "PESO")
    private float peso;

    @Column(name = "ALTURA")
    private float altura;

    @Column(name = "PEITO")
    private float peito;

    @Column(name = "CINTURA")
    private float cintura;

    @Column(name = "QUADRIL")
    private float quadril;

    @Column(name = "bracoDireito")
    private float bracoDireito;

    @Column(name = "bracoEsquerdo")
    private float bracoEsquerdo;

    @Column(name = "coxaDireita")
    private float coxaDireita;

    @Column(name = "coxaEsquerda")
    private float coxaEsquerda;

    @Column(name = "gemeosDireito")
    private float gemeosDireito;

    @Column(name = "gemoesEsquerdo")
    private float gemoesEsquerdo;

    @Column(name = "ntebracoDireito")
    private float antebracoDireito;

    @Column(name = "antebracoEsquerdo")
    private float antebracoEsquerdo;

    @Column(name = "ABDOMEM")
    private float abdomen;

    @Column(name = "dobraCutanea")
    private float dobraCutanea;

    @Column(name = "IMC")
    private float imc;

    @Column(name = "HIPERTROFIA")
    private String hipertrofia;

    @Column(name = "CONDICIONAL")
    private String condicional;

    @Column(name = "DEFINICAO")
    private String definicao;

    @Column(name = "REDUCAO")
    private String reducao;

    @Column(name = "descricaoObjetivo")
    private String descricaoObjetivo;

    @Column(name = "anotacoesGeraisFichaAvaliacao")
    private String anotacoesGeraisFichaAvaliacao;

    @Column(name = "dataCadastroFichaAvaliacao")
    private LocalDate dataCadastroFichaAvaliacao;

}
