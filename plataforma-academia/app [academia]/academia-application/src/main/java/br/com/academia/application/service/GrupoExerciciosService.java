package br.com.academia.application.service;

import br.com.academia.application.model.GrupoExercicios;
import br.com.academia.application.repository.GrupoExerciciosRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoExerciciosService {

    private GrupoExercicios grupoExercicios;

    private GrupoExerciciosRepository grupoExerciciosRepository;

    public GrupoExerciciosService(GrupoExerciciosRepository grupoExerciciosRepository) {
        this.grupoExerciciosRepository = grupoExerciciosRepository;
    }

    public GrupoExercicios cadastrarGrupoExercicios(GrupoExercicios grupoExercicios) {

        return grupoExerciciosRepository.save(grupoExercicios);

    }

    public ResponseStatusException deletarPorCodigoGrupoExercicios (Integer codigoGrupoExercicios) {

        Optional<GrupoExercicios> grupoExercicios = grupoExerciciosRepository.findById(codigoGrupoExercicios);
        if (grupoExercicios.isPresent()) {
            grupoExerciciosRepository.deleteById(codigoGrupoExercicios);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "GrupoExercicios não encontrado");

    }

    public void atualizarCadastroGrupoExercicios (GrupoExercicios grupoExercicios, Integer codigoGrupoExercicios) {

        grupoExerciciosRepository
                .findById(codigoGrupoExercicios)
                .map(grupoExerciciosExiste -> {
                    grupoExercicios.setCodigoGrupoExercicios(grupoExerciciosExiste.getCodigoGrupoExercicios());
                    grupoExerciciosRepository.save(grupoExercicios);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "GrupoExercicios não encontrado"));

    }

    public GrupoExercicios pesquisarPorCodigoGrupoExercicios (Integer codigoGrupoExercicios) {

        return grupoExerciciosRepository
                .findById(codigoGrupoExercicios)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "GrupoExercicios não enconrado")
                );
    }


    public ResponseEntity<List<GrupoExercicios>> pesquisarGrupoExerciciosPorFiltro(GrupoExercicios filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraGrupoExercicios = Example.of(filtro, filtros);

        List<GrupoExercicios> listaGrupoExercicios = grupoExerciciosRepository.findAll(filtraGrupoExercicios);
        return ResponseEntity.ok(listaGrupoExercicios);
    }

}
