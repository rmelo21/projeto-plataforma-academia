package br.com.academia.application.service;

import br.com.academia.application.model.GerarVencimentos;
import br.com.academia.application.repository.GerarVencimentosRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GerarVencimentosService {

    private GerarVencimentos gerarVencimentos;

    private GerarVencimentosRepository gerarVencimentosRepository;


    public GerarVencimentosService(GerarVencimentosRepository gerarVencimentosRepository) {
        this.gerarVencimentosRepository = gerarVencimentosRepository;
    }

    public GerarVencimentos cadastrarGerarVencimentos(GerarVencimentos gerarVencimentos) {

        return gerarVencimentosRepository.save(gerarVencimentos);

    }

    public ResponseStatusException deletarPorCodigoGerarVencimentos (Integer codigoGerarVencimentos) {

        Optional<GerarVencimentos> gerarVencimentos = gerarVencimentosRepository.findById(codigoGerarVencimentos);
        if (gerarVencimentos.isPresent()) {
            gerarVencimentosRepository.deleteById(codigoGerarVencimentos);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "GerarVencimentos não encontrado");

    }

    public void atualizarCadastroGerarVencimentos (GerarVencimentos gerarVencimentos, Integer codigoGerarVencimentos) {

        gerarVencimentosRepository
                .findById(codigoGerarVencimentos)
                .map(gerarVencimentosExiste -> {
                    gerarVencimentos.setCodigoGerarVencimentos(gerarVencimentosExiste.getCodigoGerarVencimentos());
                    gerarVencimentosRepository.save(gerarVencimentos);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "GerarVencimentos não encontrado"));

    }

    public GerarVencimentos pesquisarPorCodigoGerarVencimentos (Integer codigoGerarVencimentos) {

        return gerarVencimentosRepository
                .findById(codigoGerarVencimentos)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "GerarVencimentos não enconrado")
                );
    }


    public ResponseEntity<List<GerarVencimentos>> pesquisarGerarVencimentosPorFiltro(GerarVencimentos filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraGerarVencimentos = Example.of(filtro, filtros);

        List<GerarVencimentos> listaGerarVencimentos = gerarVencimentosRepository.findAll(filtraGerarVencimentos);
        return ResponseEntity.ok(listaGerarVencimentos);
    }



}
