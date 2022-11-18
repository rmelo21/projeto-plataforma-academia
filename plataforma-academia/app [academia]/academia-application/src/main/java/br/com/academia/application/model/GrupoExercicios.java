package br.com.academia.application.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "GRUPOEXERCICIOS")
public class GrupoExercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_grupo_exercicios", nullable = false)
    private Long codigoGrupoExercicios;

    @Column(name = "descricao_grupo_exercicios", length = 100, nullable = false)
    private String descricaoGrupoExercicios;

    @Column(name = "status", length = 1, nullable = false)
    private String status;
}
