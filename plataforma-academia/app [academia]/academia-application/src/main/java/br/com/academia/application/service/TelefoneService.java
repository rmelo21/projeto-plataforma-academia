package br.com.academia.application.service;


import br.com.academia.application.model.Telefone;
import br.com.academia.application.repository.TelefoneRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    private Telefone telefone;

    private TelefoneRepository telefoneRepository;

    public TelefoneService (TelefoneRepository telefoneRepository) {

        this.telefoneRepository = telefoneRepository;

    }

    public Telefone cadastrarTelefone(Telefone telefone) {

        return telefoneRepository.save(telefone);

    }

    public ResponseStatusException deletarPorCodigoTelefone (Integer codigoTelefone) {

        Optional<Telefone> telefone = telefoneRepository.findById(codigoTelefone);
        if (telefone.isPresent()) {
            telefoneRepository.deleteById(codigoTelefone);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Telefone não encontrado");

    }

    public void atualizarCadastroTelefone (Telefone telefone, Integer codigoTelefone) {

        telefoneRepository
                .findById(codigoTelefone)
                .map(telefoneExiste -> {
                    telefone.setCodigoTelefone(telefoneExiste.getCodigoTelefone());
                    telefoneRepository.save(telefone);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Telefone não encontrado"));

    }

    public Telefone pesquisarPorCodigoTelefone (Integer codigoTelefone) {

        return telefoneRepository
                .findById(codigoTelefone)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Telefone não enconrado")
                );
    }


    public ResponseEntity<List<Telefone>> pesquisarTelefonePorFiltro(Telefone filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraTelefone = Example.of(filtro, filtros);

        List<Telefone> listaTelefone = telefoneRepository.findAll(filtraTelefone);
        return ResponseEntity.ok(listaTelefone);
    }


}
