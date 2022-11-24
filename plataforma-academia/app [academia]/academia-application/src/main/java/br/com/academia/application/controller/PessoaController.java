package br.com.academia.application.controller;

import br.com.academia.application.model.Pessoa;
import br.com.academia.application.repository.PessoaRepository;
import br.com.academia.application.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    
    private Pessoa pessoa;
    
    private PessoaService pessoaService;
    
    private PessoaRepository pessoaRepository;


    public PessoaController(PessoaService pessoaService, PessoaRepository pessoaRepository) {
        this.pessoaService = pessoaService;
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa cadastrapessoa(@RequestBody Pessoa pessoa) {

        return pessoaService.cadastrarPessoa(pessoa);

    }

    @DeleteMapping("/deletar/{codigoPessoa}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaPessoaPorCodigo(@PathVariable Integer codigoPessoa) {

        pessoaService.deletarPorCodigoPessoa(codigoPessoa);

    }

    @PutMapping("/atualizarporcodigo/{codigoPessoa}")
    @ResponseBody
    public ResponseEntity atualizaCadastroPessoa (@RequestBody Pessoa pessoa,
                                                 @PathVariable Integer codigoPessoa) {

        pessoaService.atualizarCadastroPessoa(pessoa, codigoPessoa);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<Pessoa> pesquisarTodosPessoas() {

        return pessoaRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoPessoa}")
    public Pessoa pesquisaPorCodigo(@PathVariable Integer codigoPessoa) {

        return pessoaService.pesquisarPorCodigoPessoa(codigoPessoa);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaPessoaPorFiltro( Pessoa filtro) {

        return pessoaService.pesquisarPessoaPorFiltro(filtro);
    }


}
