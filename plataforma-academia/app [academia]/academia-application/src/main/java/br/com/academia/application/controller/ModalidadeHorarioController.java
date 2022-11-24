package br.com.academia.application.controller;

import br.com.academia.application.model.ModalidadeHorario;
import br.com.academia.application.repository.ModalidadeHorarioRepository;
import br.com.academia.application.service.ModalidadeHorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modalidadehorario")
public class ModalidadeHorarioController {
    
    private ModalidadeHorario modalidadeHorario;
    
    private ModalidadeHorarioService modalidadeHorarioService;
    
    private ModalidadeHorarioRepository modalidadeHorarioRepository;


    public ModalidadeHorarioController(ModalidadeHorarioService modalidadeHorarioService, ModalidadeHorarioRepository modalidadeHorarioRepository) {
        this.modalidadeHorarioService = modalidadeHorarioService;
        this.modalidadeHorarioRepository = modalidadeHorarioRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ModalidadeHorario cadastramodalidadeHorario(@RequestBody ModalidadeHorario modalidadeHorario) {

        return modalidadeHorarioService.cadastrarModalidadeHorario(modalidadeHorario);

    }

    @DeleteMapping("/deletar/{codigoModalidadeHorario}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaModalidadeHorarioPorCodigo(@PathVariable Integer codigoModalidadeHorario) {

        modalidadeHorarioService.deletarPorCodigoModalidadeHorario(codigoModalidadeHorario);

    }

    @PutMapping("/atualizarporcodigo/{codigoModalidadeHorario}")
    @ResponseBody
    public ResponseEntity atualizaCadastroModalidadeHorario (@RequestBody ModalidadeHorario modalidadeHorario,
                                                 @PathVariable Integer codigoModalidadeHorario) {

        modalidadeHorarioService.atualizarCadastroModalidadeHorario(modalidadeHorario, codigoModalidadeHorario);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<ModalidadeHorario> pesquisarTodosmodalidadeHorarios() {

        return modalidadeHorarioRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoModalidadeHorario}")
    public ModalidadeHorario pesquisaPorCodigo(@PathVariable Integer codigoModalidadeHorario) {

        return modalidadeHorarioService.pesquisarPorCodigoModalidadeHorario(codigoModalidadeHorario);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaModalidadeHorarioPorFiltro( ModalidadeHorario filtro) {

        return modalidadeHorarioService.pesquisarModalidadeHorarioPorFiltro(filtro);
    }


}
