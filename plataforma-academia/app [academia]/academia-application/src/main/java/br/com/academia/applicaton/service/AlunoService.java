package br.com.academia.applicaton.service;

import br.com.academia.applicaton.model.Aluno;
import br.com.academia.applicaton.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private Aluno aluno;


    public HttpStatus cadastrarAluno(Aluno aluno) {

        alunoRepository.save(aluno);

        return HttpStatus.CREATED;
    }

    public Aluno pesquisarPorCodigoAluno (Aluno codigoAluno) {

        return alunoRepository
               .findByIdAluno(codigoAluno)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

    }


    public Aluno deletarPorCodigoAluno (Integer codigoAluno) {

        return alunoRepository.delete(aluno.getCodigoAluno())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Aluno não encontrado"));
    }


    public Aluno atualizarAlunoPorCodigo(Aluno aluno) {

        return alunoRepository
                .findById(aluno.getCodigoAluno())
                .map(alunoExiste -> {
                    aluno.setCodigoAluno(alunoExiste.getCodigoAluno());
                    alunoRepository.save(aluno);
                    return alunoExiste;
                }).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT, "Aluno não encontrado"));
    }

    public List<Aluno> pesquisarAlunoPorFiltro (Aluno aluno){

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtroParaAluno = Example.of(aluno, filtros);

        return alunoRepository.findAll(filtroParaAluno);
    }
}
