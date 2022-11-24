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
@Table(name = "HISTORICOGERAL")
public class HistoricoGeral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_historico_geral", nullable = false)
    private Integer codigoHistoricoGeral;

    @Column(name = "pressao_alta", nullable = false, length = 1)
    private String pressaoAlta;

    @Column(name = "diabetes", nullable = false, length = 1)
    private String diabetes;

    @Column(name = "dificuldade_respiracao", length = 1)
    private String dificuldadeRespiracao;

    @Column(name = "problema_cardiaco", length = 1)
    private String problemaCardiaco;

    @Column(name = "lesao_muscular", length = 1)
    private String lesaoMuscular;

    @Column(name = "fratura", length = 1)
    private String fratura;

    @Column(name = "dor_costas", length = 1)
    private String dorCostas;

    @Column(name = "escoliose", length = 1)
    private String escoliose;

    @Column(name = "lordose", length = 1)
    private String lordose;

    @Column(name = "cifose", length = 1)
    private String cifose;

    @Column(name = "desmaios", length = 1)
    private String desmaios;

    @Column(name = "dor_peito", length = 1)
    private String dorPeito;

    @Column(name = "aritmia_cardica", length = 1)
    private String aritmiaCardica;

    @Column(name = "caimbras_constantes", length = 1)
    private String caimbrasConstantes;

    @Column(name = "fadiga", length = 1)
    private String fadiga;

    @Column(name = "insonia", length = 1)
    private String insonia;

    @Column(name = "ansiedade", length = 1)
    private String ansiedade;

    @Column(name = "depressao", length = 1)
    private String depressao;

    @Column(name = "medicamentos_regulares", length = 1)
    private String medicamentosRegulares;

    @Column(name = "descricao_medicamentos_regulares", length = 1)
    private String descricaoMedicamentosRegulares;

    @Column(name = "dores_articulares", length = 1)
    private String doresArticulares;

    @Column(name = "descricao_dores_articulares", length = 1)
    private String descricaoDoresArticulares;

    @Column(name = "dor_joelhos", length = 1)
    private String dorJoelhos;

    @Column(name = "grau_iniciante", nullable = false, length = 20)
    private String grauIniciante;

    @Column(name = "anotacoes_gerais_historico_geral", nullable = false, length = 200)
    private String anotacoesGeraisHistoricoGeral;

    @Builder.Default
    @Column(name = "data_cadastro_historico_geral", nullable = false)
    private LocalDate dataCadastroHistoricoGeral = LocalDate.now();
}
