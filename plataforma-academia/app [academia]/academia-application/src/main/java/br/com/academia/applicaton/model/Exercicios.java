package br.com.academia.applicaton.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "EXERCICIOS")
public class Exercicios {

    @Id
    @Column (name = "codigoExercicios")
    private int codigoExercicios;

    @Column (name = "descricaoExercicios")
    private int descricaoExercicios;

    @Column(name = "STATUS")
    private String status;
}
