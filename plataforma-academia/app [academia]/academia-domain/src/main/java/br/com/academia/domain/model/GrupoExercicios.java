package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder

public class GrupoExercicios {

    private int codigoGrupoExercicios;
    private String descricaoGrupoExercicios;
    private String status;
}
