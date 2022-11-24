package br.com.academia.application.service;

import br.com.academia.application.model.Profissional;
import br.com.academia.application.repository.ProfissionalRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    private Profissional profissional;

    private ProfissionalRepository profissionalRepository;


    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }


    public Profissional cadastrarProfissional(Profissional profissional) {

        return profissionalRepository.save(profissional);

    }

    public ResponseStatusException deletarPorCodigoProfissional (Integer codigoProfissional) {

        Optional<Profissional> profissional = profissionalRepository.findById(codigoProfissional);
        if (profissional.isPresent()) {
            profissionalRepository.deleteById(codigoProfissional);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado");

    }

    public void atualizarCadastroProfissional (Profissional profissional, Integer codigoProfissional) {

        profissionalRepository
                .findById(codigoProfissional)
                .map(profissionalExiste -> {
                    profissional.setCodigoProfissional(profissionalExiste.getCodigoProfissional());
                    profissionalRepository.save(profissional);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado"));

    }

    public Profissional pesquisarPorCodigoProfissional (Integer codigoProfissional) {

        return profissionalRepository
                .findById(codigoProfissional)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não enconrado")
                );
    }


    public ResponseEntity<List<Profissional>> pesquisarProfissionalPorFiltro(Profissional filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraProfissional = Example.of(filtro, filtros);

        List<Profissional> listaProfissional = profissionalRepository.findAll(filtraProfissional);
        return ResponseEntity.ok(listaProfissional);
    }

}
