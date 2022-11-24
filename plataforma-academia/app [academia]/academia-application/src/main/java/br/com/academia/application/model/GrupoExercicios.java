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
@Table(name = "GRUPOEXERCICIOS")
public class GrupoExercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_grupo_exercicios", nullable = false)
    private Integer codigoGrupoExercicios;

    @Column(name = "descricao_grupo_exercicios", length = 100, nullable = false)
    private String descricaoGrupoExercicios;

    @Builder.Default
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro = LocalDate.now();

    @Builder.Default
    @Column(name = "status", length = 1, nullable = false)
    private String status = "A";
}
