package br.com.academia.application.controller;

import br.com.academia.application.model.profissional;
import br.com.academia.application.model.Profissional;
import br.com.academia.application.repository.ProfissionalRepository;
import br.com.academia.application.service.ProfissionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalController {
    
    private Profissional profissional;
    
    private ProfissionalService profissionalService;
    
    private ProfissionalRepository profissionalRepository;


    public ProfissionalController(ProfissionalService profissionalService, ProfissionalRepository profissionalRepository) {
        this.profissionalService = profissionalService;
        this.profissionalRepository = profissionalRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional cadastraprofissional(@RequestBody Profissional profissional) {

        return profissionalService.cadastrarProfissional(profissional);

    }

    @DeleteMapping("/deletar/{codigoprofissional}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaProfissionalPorCodigo(@PathVariable Integer codigoProfissional) {

        profissionalService.deletarPorCodigoProfissional(codigoProfissional);

    }

    @PutMapping("/atualizarporcodigo/{codigoprofissional}")
    @ResponseBody
    public ResponseEntity atualizaCadastroProfissional (@RequestBody Profissional profissional,
                                                 @PathVariable Integer codigoProfissional) {

        profissionalService.atualizarCadastroProfissional(profissional, codigoProfissional);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<Profissional> pesquisarTodosprofissionals() {

        return profissionalRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoprofissional}")
    public Profissional pesquisaPorCodigo(@PathVariable Integer codigoProfissional) {

        return profissionalService.pesquisarPorCodigoProfissional(codigoProfissional);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaProfissionalPorFiltro( Profissional filtro) {

        return profissionalService.pesquisarProfissionalPorFiltro(filtro);
    }


}
