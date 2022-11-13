package br.com.academia.applicaton.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "GRUPOEXERCICIOS")
public class GrupoExercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGOGRUPOEXERCICIOS")
    private Integer codigoGrupoExercicios;

    @Column(name = "descricaoGrupoExercicios", length = 100)
    private String descricaoGrupoExercicios;

    @Column(name = "STATUS", length = 1)
    private String status;
}
