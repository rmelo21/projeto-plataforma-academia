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
@Table(name = "EXERCICIOS")
public class Exercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_exercicios", nullable = false)
    private Integer codigoExercicios;

    @Column(name = "descricao_exercicios", length = 40, nullable = false)
    private String descricaoExercicios;

    @Builder.Default
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro = LocalDate.now();

    @Builder.Default
    @Column(name = "status", length = 1, nullable = false)
    private String status = "A";
}
