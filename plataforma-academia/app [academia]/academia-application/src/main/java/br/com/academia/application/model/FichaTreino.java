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
@Table(name = "FICHATREINO")
public class FichaTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_ficha_treino", nullable = false)
    private Integer codigoFichaTreino;

    @Column(name = "numero_ficha", length = 4, nullable = false)
    private Integer numeroFicha;

    @Builder.Default
    @Column(name = "data_cadastro_ficha_freino", nullable = false)
    private LocalDate dataCadastroFichaTreino = LocalDate.now();

    @Column(name = "anotacoes_gerais_ficha_treino", length = 200)
    private String anotacoesGeraisFichaTreino;

    @Builder.Default
    @Column(name = "status", length = 1, nullable = false)
    private String status = "A";

}
