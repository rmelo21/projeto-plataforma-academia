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
@Table(name = "TELEFONE")
public class Telefone {

    @Id
    @Column(name = "CODIGO")
    private int codigo;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "STATUS")
    private String status;
}
