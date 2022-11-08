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
@Table(name = "FichaTreino")
public class FichaTreino {
    @Id
    @Column(name = "codigoFichaTreino")
    private int codigoFichaTreino;

    @Column(name = " numeroFicha")
    private int numeroFicha;

    @Column(name = "dataCadastroFichaTreino")
    private LocalDate dataCadastroFichaTreino;

    @Column(name = "anotacoesGeraisFichaTreino")
    private String anotacoesGeraisFichaTreino;

}
