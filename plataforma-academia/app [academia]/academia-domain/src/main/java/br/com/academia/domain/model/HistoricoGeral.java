package br.com.academia.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "HistoricoGeral")
public class HistoricoGeral {


    @Id
    @Column(name = "codigoHistoricoGeral")
    private int codigoHistoricoGeral;

    @Column(name = "pressaoAlta")
    private String pressaoAlta;

    @Column(name = "DIABETES")
    private String diabetes;

    @Column(name = "dificuldadeRespiracao")
    private String dificuldadeRespiracao;

    @Column(name = "problemaCardiaco")
    private String problemaCardiaco;

    @Column(name = "lesaoMuscular")
    private String lesaoMuscular;

    @Column(name = "FRATURA")
    private String fratura;

    @Column(name = "dorCostas")
    private String dorCostas;

    @Column(name = "ESCOLIOSE")
    private String escoliose;

    @Column(name = "LORDOSE")
    private String lordose;

    @Column(name = "CIFOSE")
    private String cifose;

    @Column(name = "DESMAIOS")
    private String desmaios;

    @Column(name = "dorPeito")
    private String dorPeito;

    @Column(name = "aritmiaCardica")
    private String aritmiaCardica;

    @Column(name = "caimbrasConstantes")
    private String caimbrasConstantes;

    @Column(name = "FADIGA")
    private String fadiga;

    @Column(name = "INSONIA")
    private String insonia;

    @Column(name = "ANSIEDADE")
    private String ansiedade;

    @Column(name = "DEPRESSAO")
    private String depressao;

    @Column(name = "medicamentosRegulares")
    private String medicamentosRegulares;

    @Column(name = "descricaoMedicamentosRegulares")
    private String descricaoMedicamentosRegulares;

    @Column(name = "doresArticulares")
    private String doresArticulares;

    @Column(name = "descricaoDoresArticulares")
    private String descricaoDoresArticulares;

    @Column(name = "dorJoelhos")
    private String dorJoelhos;

    @Column(name = "grauIniciante")
    private String grauIniciante;

    @Column(name = "anotacoesGeraisHistoricoGeral")
    private String anotacoesGeraisHistoricoGeral;

    @Column(name = "dataCadastroHistoricoGeral")
    private LocalDate dataCadastroHistoricoGeral;
}
