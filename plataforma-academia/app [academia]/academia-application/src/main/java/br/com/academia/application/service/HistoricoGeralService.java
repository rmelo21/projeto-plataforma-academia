package br.com.academia.application.service;

import br.com.academia.application.model.HistoricoGeral;
import br.com.academia.application.repository.HistoricoGeralRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoGeralService {

    private HistoricoGeral historicoGeral;

    private HistoricoGeralRepository historicoGeralRepository;

    public HistoricoGeralService( HistoricoGeralRepository historicoGeralRepository) {
        this.historicoGeralRepository = historicoGeralRepository;
    }

    public HistoricoGeral cadastrarHistoricoGeral(HistoricoGeral historicoGeral) {

        return historicoGeralRepository.save(historicoGeral);

    }

    public ResponseStatusException deletarPorCodigoHistoricoGeral (Integer codigoHistoricoGeral) {

        Optional<HistoricoGeral> historicoGeral = historicoGeralRepository.findById(codigoHistoricoGeral);
        if (historicoGeral.isPresent()) {
            historicoGeralRepository.deleteById(codigoHistoricoGeral);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "HistoricoGeral não encontrado");

    }

    public void atualizarCadastroHistoricoGeral (HistoricoGeral historicoGeral, Integer codigoHistoricoGeral) {

        historicoGeralRepository
                .findById(codigoHistoricoGeral)
                .map(historicoGeralExiste -> {
                    historicoGeral.setCodigoHistoricoGeral(historicoGeralExiste.getCodigoHistoricoGeral());
                    historicoGeralRepository.save(historicoGeral);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HistoricoGeral não encontrado"));

    }

    public HistoricoGeral pesquisarPorCodigoHistoricoGeral (Integer codigoHistoricoGeral) {

        return historicoGeralRepository
                .findById(codigoHistoricoGeral)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "HistoricoGeral não enconrado")
                );
    }


    public ResponseEntity<List<HistoricoGeral>> pesquisarHistoricoGeralPorFiltro(HistoricoGeral filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraHistoricoGeral = Example.of(filtro, filtros);

        List<HistoricoGeral> listaHistoricoGeral = historicoGeralRepository.findAll(filtraHistoricoGeral);
        return ResponseEntity.ok(listaHistoricoGeral);
    }


}
