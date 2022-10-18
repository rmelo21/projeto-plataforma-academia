package br.com.academia.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
@Data
@Builder

public class SeriesExercicios {

    private int codigoSeriesExercicios;
    private int serieRepeticao;
    private int carga;
    private int cargaMaxima;
    private String observacao;
    private String status;

}
