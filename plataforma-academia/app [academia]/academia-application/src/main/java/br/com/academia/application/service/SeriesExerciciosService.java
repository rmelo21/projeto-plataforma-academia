package br.com.academia.application.service;


import br.com.academia.application.model.SeriesExercicios;
import br.com.academia.application.repository.SeriesExerciciosRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesExerciciosService {

    private SeriesExercicios seriesExercicios;

    private SeriesExerciciosRepository seriesExerciciosRepository;


    public SeriesExerciciosService(SeriesExerciciosRepository seriesExerciciosRepository) {
        this.seriesExerciciosRepository = seriesExerciciosRepository;
    }

    public SeriesExercicios cadastrarSeriesExercicios(SeriesExercicios seriesExercicios) {

        return seriesExerciciosRepository.save(seriesExercicios);

    }

    public ResponseStatusException deletarPorCodigoSeriesExercicios (Integer codigoSeriesExercicios) {

        Optional<SeriesExercicios> seriesExercicios = seriesExerciciosRepository.findById(codigoSeriesExercicios);
        if (seriesExercicios.isPresent()) {
            seriesExerciciosRepository.deleteById(codigoSeriesExercicios);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "SeriesExercicios não encontrado");

    }

    public void atualizarCadastroSeriesExercicios (SeriesExercicios seriesExercicios, Integer codigoSeriesExercicios) {

        seriesExerciciosRepository
                .findById(codigoSeriesExercicios)
                .map(seriesExerciciosExiste -> {
                    seriesExercicios.setCodigoSeriesExercicios(seriesExerciciosExiste.getCodigoSeriesExercicios());
                    seriesExerciciosRepository.save(seriesExercicios);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SeriesExercicios não encontrado"));

    }

    public SeriesExercicios pesquisarPorCodigoSeriesExercicios (Integer codigoSeriesExercicios) {

        return seriesExerciciosRepository
                .findById(codigoSeriesExercicios)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "SeriesExercicios não enconrado")
                );
    }


    public ResponseEntity<List<SeriesExercicios>> pesquisarSeriesExerciciosPorFiltro(SeriesExercicios filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraSeriesExercicios = Example.of(filtro, filtros);

        List<SeriesExercicios> listaSeriesExercicios = seriesExerciciosRepository.findAll(filtraSeriesExercicios);
        return ResponseEntity.ok(listaSeriesExercicios);
    }


}
