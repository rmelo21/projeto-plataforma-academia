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
@Table(name = "TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_telefone", nullable = false)
    private Integer codigoTelefone;

    @Column(name = "numero", nullable = false, length = 11)
    private String numero;

    @Column(name = "status", nullable = false, length = 1)
    private String status;
}
