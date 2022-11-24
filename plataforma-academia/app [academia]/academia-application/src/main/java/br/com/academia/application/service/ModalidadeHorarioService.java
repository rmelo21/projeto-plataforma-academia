package br.com.academia.application.service;

import br.com.academia.application.model.ModalidadeHorario;
import br.com.academia.application.repository.ModalidadeHorarioRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadeHorarioService {

    private ModalidadeHorario modalidadeHorario;

    private ModalidadeHorarioRepository modalidadeHorarioRepository;

    public ModalidadeHorarioService (ModalidadeHorarioRepository modalidadeHorarioRepository) {
        this.modalidadeHorarioRepository = modalidadeHorarioRepository;
    }


    public ModalidadeHorario cadastrarModalidadeHorario(ModalidadeHorario modalidadeHorario) {

        return modalidadeHorarioRepository.save(modalidadeHorario);

    }

    public ResponseStatusException deletarPorCodigoModalidadeHorario (Integer codigoModalidadeHorario) {

        Optional<ModalidadeHorario> modalidadeHorario = modalidadeHorarioRepository.findById(codigoModalidadeHorario);
        if (modalidadeHorario.isPresent()) {
            modalidadeHorarioRepository.deleteById(codigoModalidadeHorario);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "ModalidadeHorario não encontrado");

    }

    public void atualizarCadastroModalidadeHorario (ModalidadeHorario modalidadeHorario, Integer codigoModalidadeHorario) {

        modalidadeHorarioRepository
                .findById(codigoModalidadeHorario)
                .map(modalidadeHorarioExiste -> {
                    modalidadeHorarioExiste.setCodigoModalidadeHorario(modalidadeHorarioExiste.getCodigoModalidadeHorario());
                    modalidadeHorarioRepository.save(modalidadeHorario);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ModalidadeHorario não encontrado"));

    }

    public ModalidadeHorario pesquisarPorCodigoModalidadeHorario (Integer codigoModalidadeHorario) {

        return modalidadeHorarioRepository
                .findById(codigoModalidadeHorario)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "ModalidadeHorario não enconrado")
                );
    }


    public ResponseEntity<List<ModalidadeHorario>> pesquisarModalidadeHorarioPorFiltro(ModalidadeHorario filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraModalidadeHorario = Example.of(filtro, filtros);

        List<ModalidadeHorario> listaModalidadeHorario = modalidadeHorarioRepository.findAll(filtraModalidadeHorario);
        return ResponseEntity.ok(listaModalidadeHorario);
    }


}
