package br.com.academia.application.service;

import br.com.academia.application.model.Aluno;
import br.com.academia.application.repository.AlunoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private Aluno aluno;

    private AlunoRepository alunoRepository;


    public AlunoService (AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrarAluno(Aluno aluno) {

        return alunoRepository.save(aluno);

    }

    public ResponseStatusException deletarPorCodigoAluno (Integer codigoAluno) {

        Optional<Aluno> aluno = alunoRepository.findById(codigoAluno);
        if (aluno.isPresent()) {
            alunoRepository.deleteById(codigoAluno);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");

    }

    public void atualizarCadastroAluno (Aluno aluno, Integer codigoAluno) {

        alunoRepository
                .findById(codigoAluno)
                .map(alunoExiste -> {
                    aluno.setCodigoAluno(alunoExiste.getCodigoAluno());
                    alunoRepository.save(aluno);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

    }

    public Aluno pesquisarPorCodigoAluno (Integer codigoAluno) {

        return alunoRepository
                .findById(codigoAluno)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não enconrado")
                );
    }


    public ResponseEntity<List<Aluno>> pesquisarAlunoPorFiltro(Aluno filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraAluno = Example.of(filtro, filtros);

        List<Aluno> listaAluno = alunoRepository.findAll(filtraAluno);
        return ResponseEntity.ok(listaAluno);
    }


}
