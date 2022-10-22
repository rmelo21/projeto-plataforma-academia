package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
@Builder

public class FichaAvaliacao {

    private int codigoFichaAvaliacao;
    private float peso;
    private float altura;
    private float peito;
    private float cintura;
    private float quadril;
    private float bracoDireito;
    private float bracoEsquerdo;
    private float coxaDireita;
    private float coxaEsquerda;
    private float gemeosDireito;
    private float gemoesEsquerdo;
    private float antebracoDireito;
    private float antebracoEsquerdo;
    private float abdomen;
    private float dobraCutanea;
    private float imc;
    private String hipertrofia;
    private String condicional;
    private String definicao;
    private String reducao;
    private String descricaoObjetivo;
    private String anotacoesGeraisFichaAvaliacao;
    private LocalDate dataCadastroFichaAvaliacao;

}
