package br.com.academia.domain.ports.in;


import br.com.academia.domain.model.Aluno;

public interface ProcessarEventoPort {


    void validarAluno(Aluno aluno);

}
