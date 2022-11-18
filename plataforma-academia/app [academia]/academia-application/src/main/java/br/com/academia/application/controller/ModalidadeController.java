package br.com.academia.application.controller;

import br.com.academia.application.model.modalidade;
import br.com.academia.application.model.Modalidade;
import br.com.academia.application.repository.ModalidadeRepository;
import br.com.academia.application.service.ModalidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modalidade")
public class ModalidadeController {
    
    private Modalidade modalidade;
    
    private ModalidadeService modalidadeService;
    
    private ModalidadeRepository modalidadeRepository;


    public ModalidadeController(ModalidadeService modalidadeService, ModalidadeRepository modalidadeRepository) {
        this.modalidadeService = modalidadeService;
        this.modalidadeRepository = modalidadeRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Modalidade cadastramodalidade(@RequestBody Modalidade modalidade) {

        return modalidadeService.cadastrarModalidade(modalidade);

    }

    @DeleteMapping("/deletar/{codigomodalidade}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaModalidadePorCodigo(@PathVariable Integer codigoModalidade) {

        modalidadeService.deletarPorCodigoModalidade(codigoModalidade);

    }

    @PutMapping("/atualizarporcodigo/{codigomodalidade}")
    @ResponseBody
    public ResponseEntity atualizaCadastroModalidade (@RequestBody Modalidade modalidade,
                                                 @PathVariable Integer codigoModalidade) {

        modalidadeService.atualizarCadastroModalidade(modalidade, codigoModalidade);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<Modalidade> pesquisarTodosmodalidades() {

        return modalidadeRepository.findAll();

    }

    @GetMapping("pesquisar/{codigomodalidade}")
    public Modalidade pesquisaPorCodigo(@PathVariable Integer codigoModalidade) {

        return modalidadeService.pesquisarPorCodigoModalidade(codigoModalidade);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaModalidadePorFiltro( Modalidade filtro) {

        return modalidadeService.pesquisarModalidadePorFiltro(filtro);
    }


}
