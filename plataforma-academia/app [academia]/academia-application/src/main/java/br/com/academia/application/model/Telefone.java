package br.com.academia.application.model;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component


@Entity
@Table(name = "TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_telefone", nullable = false)
    private Integer codigoTelefone;

    @Column(name = "numero", nullable = false, length = 11)
    private String numero;

    @Builder.Default
    @Column(name = "status", length = 1, nullable = false)
    private String status = "A";
}
