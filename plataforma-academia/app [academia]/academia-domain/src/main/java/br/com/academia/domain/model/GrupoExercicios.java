package br.com.academia.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "GrupoExercicios ")
public class GrupoExercicios {

    @Id
    @Column(name = "codigoGrupoExercicios")
    private int codigoGrupoExercicios;

    @Column(name = "descricaoGrupoExercicios;")
    private String descricaoGrupoExercicios;

    @Column(name = "STATUS")
    private String status;
}
