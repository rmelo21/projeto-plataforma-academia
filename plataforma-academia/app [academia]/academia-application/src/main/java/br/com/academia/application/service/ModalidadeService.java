package br.com.academia.application.service;


import br.com.academia.application.model.Modalidade;
import br.com.academia.application.repository.ModalidadeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadeService {

    private Modalidade modalidade;

    private ModalidadeRepository modalidadeRepository;

    public ModalidadeService (ModalidadeRepository modalidadeRepository) {
        this.modalidadeRepository = modalidadeRepository;

    }

    public Modalidade cadastrarModalidade(Modalidade modalidade) {

        return modalidadeRepository.save(modalidade);

    }

    public ResponseStatusException deletarPorCodigoModalidade (Integer codigoModalidade) {

        Optional<Modalidade> modalidade = modalidadeRepository.findById(codigoModalidade);
        if (modalidade.isPresent()) {
            modalidadeRepository.deleteById(codigoModalidade);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Modalidade não encontrado");

    }

    public void atualizarCadastroModalidade (Modalidade modalidade, Integer codigoModalidade) {

        modalidadeRepository
                .findById(codigoModalidade)
                .map(modalidadeExiste -> {
                    modalidadeExiste.setCodigoModalidade(modalidadeExiste.getCodigoModalidade());
                    modalidadeRepository.save(modalidade);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modalidade não encontrado"));

    }

    public Modalidade pesquisarPorCodigoModalidade (Integer codigoModalidade) {

        return modalidadeRepository
                .findById(codigoModalidade)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Modalidade não enconrado")
                );
    }


    public ResponseEntity<List<Modalidade>> pesquisarModalidadePorFiltro(Modalidade filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraModalidade = Example.of(filtro, filtros);

        List<Modalidade> listaModalidade = modalidadeRepository.findAll(filtraModalidade);
        return ResponseEntity.ok(listaModalidade);
    }



}
