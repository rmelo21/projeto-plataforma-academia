package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@Entity
@Table(name = "TELEFONE")
@NoArgsConstructor
public class Telefone {

    @Id
    @Column(name = "CODIGO")
    private int codigo;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "STATUS")
    private String status;
}
