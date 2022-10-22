package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Data
@Builder

public class HistoricoGeral {

    private int codigoHistoricoGeral;
    private String pressaoAlta;
    private String diabetes;
    private String dificuldadeRespiracao;
    private String problemaCardiaco;
    private String lesaoMuscular;
    private String fratura;
    private String dorCostas;
    private String escoliose;
    private String lordose;
    private String cifose;
    private String desmaios;
    private String dorPeito;
    private String aritmiaCardica;
    private String caimbrasConstantes;
    private String fadiga;
    private String insonia;
    private String ansiedade;
    private String depressao;
    private String medicamentosRegulares;
    private String descricaoMedicamentosRegulares;
    private String doresArticulares;
    private String descricaoDoresArticulares;
    private String dorJoelhos;
    private String grauIniciante;
    private String anotacoesGeraisHistoricoGeral;
    private LocalDate dataCadastroHistoricoGeral;
}
