package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder

public class Telefone {

    private int codigo;
    private String numero;
    private String status;
}
