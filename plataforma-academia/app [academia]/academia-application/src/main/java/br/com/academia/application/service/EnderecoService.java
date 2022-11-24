package br.com.academia.application.service;

import br.com.academia.application.model.Endereco;
import br.com.academia.application.repository.EnderecoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private Endereco endereco;

    private EnderecoRepository enderecoRepository;

    public EnderecoService (EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }


    public Endereco cadastrarEndereco (Endereco endereco) {

        return enderecoRepository.save(endereco);
    }


    public ResponseStatusException deletarPorCodigoEndereco (Integer codigoEndereco) {

        Optional<Endereco> endereco = enderecoRepository.findById(codigoEndereco);
        if (endereco.isPresent()) {
            enderecoRepository.deleteById(codigoEndereco);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");

    }

    public void atualizarCadastroEndereco (Endereco endereco, Integer codigoEndereco) {

        enderecoRepository
                .findById(codigoEndereco)
                .map(enderecoExiste -> {
                    endereco.setCodigoEndereco(enderecoExiste.getCodigoEndereco());
                    enderecoRepository.save(endereco);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));

    }

    public Endereco pesquisarPorCodigoEndereco (Integer codigoEndereco) {

        return enderecoRepository
                .findById(codigoEndereco)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não enconrado")
                );
    }


    public ResponseEntity<List<Endereco>> pesquisarEnderecoPorFiltro(Endereco filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraEndereco = Example.of(filtro, filtros);

        List<Endereco> listaEndereco = enderecoRepository.findAll(filtraEndereco);
        return ResponseEntity.ok(listaEndereco);
    }



}
