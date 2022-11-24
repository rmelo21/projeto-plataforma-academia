package br.com.academia.application.controller;


import br.com.academia.application.model.Endereco;
import br.com.academia.application.repository.EnderecoRepository;
import br.com.academia.application.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private Endereco endereco;

    private EnderecoService enderecoService;

    private EnderecoRepository enderecoRepository;

    public EnderecoController (EnderecoRepository enderecoRepository, EnderecoService enderecoService) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoService = enderecoService;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco cadastraEndereco(@RequestBody Endereco endereco) {

        return enderecoService.cadastrarEndereco(endereco);

    }

    @DeleteMapping("/deletar/{codigoEndereco}")
    public void deletaEnderecoPorCodigo(@PathVariable Integer codigoEndereco) {

        enderecoService.deletarPorCodigoEndereco(codigoEndereco);

    }

    @PutMapping("/atualizarporcodigo/{codigoEndereco}")
    @ResponseBody
    public ResponseEntity atualizaCadastroEndereco (@RequestBody Endereco endereco,
                                                 @PathVariable Integer codigoEndereco) {

        enderecoService.atualizarCadastroEndereco (endereco, codigoEndereco);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<Endereco> pesquisarTodosEnderecos() {

        return enderecoRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoEndereco}")
    public Endereco pesquisaPorCodigo(@PathVariable Integer codigoEndereco) {

        return enderecoService.pesquisarPorCodigoEndereco(codigoEndereco);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaEnderecoPorFiltro( Endereco filtro) {

        return enderecoService.pesquisarEnderecoPorFiltro(filtro);
    }




}
