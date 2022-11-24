package br.com.academia.application.service;

import br.com.academia.application.model.FichaTreino;
import br.com.academia.application.repository.FichaTreinoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FichaTreinoService {

    private FichaTreino fichaTreino;

    private FichaTreinoRepository fichaTreinoRepository;


    public FichaTreinoService(FichaTreinoRepository fichaTreinoRepository) {
        this.fichaTreinoRepository = fichaTreinoRepository;
    }

    public FichaTreino cadastrarFichaTreino(FichaTreino fichaTreino) {

        return fichaTreinoRepository.save(fichaTreino);

    }

    public ResponseStatusException deletarPorCodigoFichaTreino (Integer codigoFichaTreino) {

        Optional<FichaTreino> fichaTreino = fichaTreinoRepository.findById(codigoFichaTreino);
        if (fichaTreino.isPresent()) {
            fichaTreinoRepository.deleteById(codigoFichaTreino);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "FichaTreino não encontrado");

    }

    public void atualizarCadastroFichaTreino (FichaTreino fichaTreino, Integer codigoFichaTreino) {

        fichaTreinoRepository
                .findById(codigoFichaTreino)
                .map(fichaTreinoExiste -> {
                    fichaTreino.setCodigoFichaTreino(fichaTreinoExiste.getCodigoFichaTreino());
                    fichaTreinoRepository.save(fichaTreino);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FichaTreino não encontrado"));

    }

    public FichaTreino pesquisarPorCodigoFichaTreino (Integer codigoFichaTreino) {

        return fichaTreinoRepository
                .findById(codigoFichaTreino)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "FichaTreino não enconrado")
                );
    }


    public ResponseEntity<List<FichaTreino>> pesquisarFichaTreinoPorFiltro(FichaTreino filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraFichaTreino = Example.of(filtro, filtros);

        List<FichaTreino> listaFichaTreino = fichaTreinoRepository.findAll(filtraFichaTreino);
        return ResponseEntity.ok(listaFichaTreino);
    }


}
