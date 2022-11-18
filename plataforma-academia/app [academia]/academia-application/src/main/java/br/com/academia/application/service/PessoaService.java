package br.com.academia.application.service;

import br.com.academia.application.model.Pessoa;
import br.com.academia.application.repository.PessoaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private Pessoa pessoa;

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public Pessoa cadastrarPessoa(Pessoa pessoa) {

        return pessoaRepository.save(pessoa);

    }

    public ResponseStatusException deletarPorCodigoPessoa (Integer codigoPessoa) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(codigoPessoa);
        if (pessoa.isPresent()) {
            pessoaRepository.deleteById(codigoPessoa);

        }
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrado");

    }

    public void atualizarCadastroPessoa (Pessoa pessoa, Integer codigoPessoa) {

        pessoaRepository
                .findById(codigoPessoa)
                .map(pessoaExiste -> {
                    pessoa.setCodigoPessoa(pessoaExiste.getCodigoPessoa());
                    pessoaRepository.save(pessoa);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrado"));

    }

    public Pessoa pesquisarPorCodigoPessoa (Integer codigoPessoa) {

        return pessoaRepository
                .findById(codigoPessoa)
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não enconrado")
                );
    }


    public ResponseEntity<List<Pessoa>> pesquisarPessoaPorFiltro(Pessoa filtro) {

        //TODO if caso request venha vazio

        ExampleMatcher filtros = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example filtraPessoa = Example.of(filtro, filtros);

        List<Pessoa> listaPessoa = pessoaRepository.findAll(filtraPessoa);
        return ResponseEntity.ok(listaPessoa);
    }

}
