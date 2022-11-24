package br.com.academia.application.service;

import br.com.academia.application.model.FichaAvaliacao;
import br.com.academia.application.repository.FichaAvaliacaoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FichaAvaliacaoService {

    private FichaAvaliacao fichaAvaliacao;

    private FichaAvaliacaoRepository fichaAvaliacaoRepository;


    public FichaAvaliacaoService(FichaAvaliacaoRepository fichaAvaliacaoRepository) {
        this.fichaAvaliacaoRepository = fichaAvaliacaoRepository;
    }

    public FichaAvaliacao cadastrarFichaAvaliacao(FichaAvaliacao fichaAvaliacao) {

        return fichaAvaliacaoRepository.save(fichaAvaliacao);

    }

    public ResponseStatusException deletarPorCodigoFichaAvaliacao (Integer codigoFichaAvaliacao) {

        Optional<FichaAvaliacao> fichaAvaliacao = fichaAvaliacaoRepository.findById(codigoFichaAvaliacao);
        if (fichaAvaliacao.isPresent()) {
            fichaAvaliacaoRepository.deleteById(codigoFichaAvaliacao);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "fichaAvaliacao não encontrado");

    }

    public void atualizarCadastroFichaAvaliacao (FichaAvaliacao fichaAvaliacao, Integer codigoFichaAvaliacao) {

        fichaAvaliacaoRepository
                .findById(codigoFichaAvaliacao)
                .map(fichaAvaliacaoExiste -> {
                    fichaAvaliacao.setCodigoFichaAvalilacao(fichaAvaliacaoExiste.getCodigoFichaAvalilacao());
                    fichaAvaliacaoRepository.save(fichaAvaliacao);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FichaAvaliacao não encontrado"));

    }

    public FichaAvaliacao pesquisarPorCodigoFichaAvaliacao (Integer codigoFichaAvalilacao) {

        return fichaAvaliacaoRepository
                .findById(codigoFichaAvalilacao)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "FichaAvaliacao não enconrado")
                );
    }


    public ResponseEntity<List<FichaAvaliacao>> pesquisarFichaAvaliacaoPorFiltro(FichaAvaliacao filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraFichaAvaliacao = Example.of(filtro, filtros);

        List<FichaAvaliacao> listaFichaAvaliacao = fichaAvaliacaoRepository.findAll(filtraFichaAvaliacao);
        return ResponseEntity.ok(listaFichaAvaliacao);
    }


}
