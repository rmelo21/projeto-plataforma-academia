package br.com.academia.application.controller;

import br.com.academia.application.model.Telefone;
import br.com.academia.application.repository.TelefoneRepository;
import br.com.academia.application.service.TelefoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telefone")
public class TelefoneController {
    
    private Telefone telefone;
    
    private TelefoneService telefoneService;
    
    private TelefoneRepository telefoneRepository;


    public TelefoneController(TelefoneService telefoneService, TelefoneRepository telefoneRepository) {
        this.telefoneService = telefoneService;
        this.telefoneRepository = telefoneRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Telefone cadastraTelefone(@RequestBody Telefone telefone) {

        return telefoneService.cadastrarTelefone(telefone);

    }

    @DeleteMapping("/deletar/{codigoTelefone}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaTelefonePorCodigo(@PathVariable Integer codigoTelefone) {

        telefoneService.deletarPorCodigoTelefone(codigoTelefone);

    }

    @PutMapping("/atualizarporcodigo/{codigoTelefone}")
    @ResponseBody
    public ResponseEntity atualizaCadastroTelefone (@RequestBody Telefone telefone,
                                                 @PathVariable Integer codigoTelefone) {

        telefoneService.atualizarCadastroTelefone(telefone, codigoTelefone);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<Telefone> pesquisarTodosTelefones() {

        return telefoneRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoTelefone}")
    public Telefone pesquisaPorCodigo(@PathVariable Integer codigoTelefone) {

        return telefoneService.pesquisarPorCodigoTelefone(codigoTelefone);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaTelefonePorFiltro( Telefone filtro) {

        return telefoneService.pesquisarTelefonePorFiltro(filtro);
    }


}
