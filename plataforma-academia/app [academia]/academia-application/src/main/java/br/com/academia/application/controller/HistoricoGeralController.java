package br.com.academia.application.controller;

import br.com.academia.application.model.HistoricoGeral;
import br.com.academia.application.repository.HistoricoGeralRepository;
import br.com.academia.application.service.HistoricoGeralService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historicogeral")
public class HistoricoGeralController {
    
    private HistoricoGeral historicoGeral;
    
    private HistoricoGeralService historicoGeralService;
    
    private HistoricoGeralRepository historicoGeralRepository;


    public HistoricoGeralController(HistoricoGeralService historicoGeralService, HistoricoGeralRepository historicoGeralRepository) {
        this.historicoGeralService = historicoGeralService;
        this.historicoGeralRepository = historicoGeralRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public HistoricoGeral cadastrahistoricoGeral(@RequestBody HistoricoGeral historicoGeral) {

        return historicoGeralService.cadastrarHistoricoGeral(historicoGeral);

    }

    @DeleteMapping("/deletar/{codigoHistoricoGeral}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaHistoricoGeralPorCodigo(@PathVariable Integer codigoHistoricoGeral) {

        historicoGeralService.deletarPorCodigoHistoricoGeral(codigoHistoricoGeral);

    }

    @PutMapping("/atualizarporcodigo/{codigoHistoricoGeral}")
    @ResponseBody
    public ResponseEntity atualizaCadastroHistoricoGeral (@RequestBody HistoricoGeral historicoGeral,
                                                 @PathVariable Integer codigoHistoricoGeral) {

        historicoGeralService.atualizarCadastroHistoricoGeral(historicoGeral, codigoHistoricoGeral);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<HistoricoGeral> pesquisarTodoshistoricoGerals() {

        return historicoGeralRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoHistoricoGeral}")
    public HistoricoGeral pesquisaPorCodigo(@PathVariable Integer codigoHistoricoGeral) {

        return historicoGeralService.pesquisarPorCodigoHistoricoGeral(codigoHistoricoGeral);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaHistoricoGeralPorFiltro( HistoricoGeral filtro) {

        return historicoGeralService.pesquisarHistoricoGeralPorFiltro(filtro);
    }



}
