package br.com.academia.application.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

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

    @Column(name = "data_cadastro_ficha_freino", nullable = false)
    private LocalDate dataCadastroFichaTreino;

    @Column(name = "anotacoes_gerais_ficha_treino", length = 200)
    private String anotacoesGeraisFichaTreino;

}
