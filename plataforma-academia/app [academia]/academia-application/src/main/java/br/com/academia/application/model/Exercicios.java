package br.com.academia.application.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

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
    private Integer descricaoExercicios;

    @Column(name = "status", length = 1, nullable = false)
    private String status;
}
