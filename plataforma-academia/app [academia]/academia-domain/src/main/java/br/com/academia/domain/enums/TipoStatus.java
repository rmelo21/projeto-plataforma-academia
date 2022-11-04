package br.com.academia.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoStatus {

    CANCELADO("C", "1"),
    INATIVO("I", "2"),
    ATIVO("A", "3");

    private final String sigla;
    private final String codigo;

    public final TipoStatus getCodigo (String codigo) {

        return TipoStatus.valueOf(sigla);

    }

}
