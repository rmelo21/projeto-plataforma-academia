package br.com.academia.application.controller;


import br.com.academia.application.model.FichaAvaliacao;
import br.com.academia.application.repository.FichaAvaliacaoRepository;
import br.com.academia.application.service.FichaAvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichaavaliacao")
public class FichaAvaliacaoController {
    
    private FichaAvaliacao fichaAvaliacao;
    
    private FichaAvaliacaoService fichaAvaliacaoService;
    
    private FichaAvaliacaoRepository fichaAvaliacaoRepository;
    
    
    public FichaAvaliacaoController(FichaAvaliacaoService fichaAvaliacaoService, FichaAvaliacaoRepository fichaAvaliacaoRepository) {
        this.fichaAvaliacaoService = fichaAvaliacaoService;
        this.fichaAvaliacaoRepository = fichaAvaliacaoRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public FichaAvaliacao cadastraFichaAvaliacao(@RequestBody FichaAvaliacao fichaAvaliacao) {

        return fichaAvaliacaoService.cadastrarFichaAvaliacao(fichaAvaliacao);

    }

    @DeleteMapping("/deletar/{codigoFichaAvalilacao}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaFichaAvaliacaoPorCodigo(@PathVariable Integer codigofichaAvaliacao) {

        fichaAvaliacaoService.deletarPorCodigoFichaAvaliacao(codigofichaAvaliacao);

    }

    @PutMapping("/atualizarporcodigo/{codigoFichaAvalilacao}")
    @ResponseBody
    public ResponseEntity atualizaCadastroFichaAvaliacao (@RequestBody FichaAvaliacao fichaAvaliacao,
                                                 @PathVariable Integer codigofichaAvaliacao) {

        fichaAvaliacaoService.atualizarCadastroFichaAvaliacao(fichaAvaliacao, codigofichaAvaliacao);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<FichaAvaliacao> pesquisarTodosFichaAvaliacaos() {

        return fichaAvaliacaoRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoFichaAvalilacao}")
    public FichaAvaliacao pesquisaPorCodigo(@PathVariable Integer codigoFichaAvalilacao) {

        return fichaAvaliacaoService.pesquisarPorCodigoFichaAvaliacao(codigoFichaAvalilacao);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisafichaAvaliacaoPorFiltro( FichaAvaliacao filtro) {

        return fichaAvaliacaoService.pesquisarFichaAvaliacaoPorFiltro(filtro);
    }


}
