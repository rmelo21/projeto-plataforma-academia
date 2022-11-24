package br.com.academia.application.service;

import br.com.academia.application.model.Matricula;
import br.com.academia.application.repository.MatriculaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    private Matricula matricula;

    private MatriculaRepository matriculaRepository;

    public MatriculaService ( MatriculaRepository matriculaRepository ) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula cadastrarMatricula(Matricula matricula) {

        return matriculaRepository.save(matricula);

    }

    public ResponseStatusException deletarPorCodigoMatricula (Integer codigoMatricula) {

        Optional<Matricula> matricula = matriculaRepository.findById(codigoMatricula);
        if (matricula.isPresent()) {
            matriculaRepository.deleteById(codigoMatricula);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula não encontrado");

    }

    public void atualizarCadastroMatricula (Matricula matricula, Integer codigoMatricula) {

        matriculaRepository
                .findById(codigoMatricula)
                .map(matriculaExiste -> {
                    matricula.setCodigoMatricula(matriculaExiste.getCodigoMatricula());
                    matriculaRepository.save(matricula);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula não encontrado"));

    }

    public Matricula pesquisarPorCodigoMatricula (Integer codigoMatricula) {

        return matriculaRepository
                .findById(codigoMatricula)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula não enconrado")
                );
    }


    public ResponseEntity<List<Matricula>> pesquisarMatriculaPorFiltro(Matricula filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraMatricula = Example.of(filtro, filtros);

        List<Matricula> listaMatricula = matriculaRepository.findAll(filtraMatricula);
        return ResponseEntity.ok(listaMatricula);
    }



}
