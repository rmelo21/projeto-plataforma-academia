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
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_endereco", nullable = false)
    private Integer codigoEndereco;

    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "numero", length = 4, nullable = false)
    private Integer numero;

    @Column(name = "status", length = 1, nullable = false)
    private String status;
}
