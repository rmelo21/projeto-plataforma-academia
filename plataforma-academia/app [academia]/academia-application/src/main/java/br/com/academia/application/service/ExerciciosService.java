package br.com.academia.application.service;

import br.com.academia.application.model.Exercicios;
import br.com.academia.application.repository.ExerciciosRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciciosService {

    private Exercicios exercicios;

    private ExerciciosRepository exerciciosRepository;

    public ExerciciosService (ExerciciosRepository exerciciosRepository) {
        this.exerciciosRepository = exerciciosRepository;
    }

    public Exercicios cadastrarExercicios(Exercicios exercicios) {

        return exerciciosRepository.save(exercicios);

    }

    public ResponseStatusException deletarPorCodigoExercicios (Integer codigoExercicios) {

        Optional<Exercicios> exercicios = exerciciosRepository.findById(codigoExercicios);
        if (exercicios.isPresent()) {
            exerciciosRepository.deleteById(codigoExercicios);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercicios não encontrado");

    }

    public void atualizarCadastroExercicios (Exercicios exercicios, Integer codigoExercicios) {

        exerciciosRepository
                .findById(codigoExercicios)
                .map(ExerciciosExiste -> {
                    exercicios.setCodigoExercicios(ExerciciosExiste.getCodigoExercicios());
                    exerciciosRepository.save(exercicios);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercicios não encontrado"));

    }

    public Exercicios pesquisarPorCodigoExercicios (Integer codigoExercicios) {

        return exerciciosRepository
                .findById(codigoExercicios)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercicios não enconrado")
                );
    }


    public ResponseEntity<List<Exercicios>> pesquisarExerciciosPorFiltro(Exercicios filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraExercicios = Example.of(filtro, filtros);

        List<Exercicios> listaExercicios = exerciciosRepository.findAll(filtraExercicios);
        return ResponseEntity.ok(listaExercicios);
    }



}
