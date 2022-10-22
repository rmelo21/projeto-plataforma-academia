package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder

public class Endereco {

    private int codigoEndereco;
    private String logradouro;
    private int numero;
    private String status;
}
