package br.com.academia.application.controller;


import br.com.academia.application.model.FichaTreino;
import br.com.academia.application.repository.FichaTreinoRepository;
import br.com.academia.application.service.FichaTreinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichatreino")
public class FichaTreinoController {
    
    private FichaTreino fichaTreino;
    
    private FichaTreinoService fichaTreinoService;
    
    private FichaTreinoRepository fichaTreinoRepository;

    public FichaTreinoController(FichaTreinoService fichaTreinoService, FichaTreinoRepository fichaTreinoRepository) {
        this.fichaTreinoService = fichaTreinoService;
        this.fichaTreinoRepository = fichaTreinoRepository;
    }


    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public FichaTreino cadastraFichaTreino(@RequestBody FichaTreino fichaTreino) {

        return fichaTreinoService.cadastrarFichaTreino(fichaTreino);

    }

    @DeleteMapping("/deletar/{codigofichatreino}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaFichaTreinoPorCodigo(@PathVariable Integer codigoFichaTreino) {

        fichaTreinoService.deletarPorCodigoFichaTreino(codigoFichaTreino);

    }

    @PutMapping("/atualizarporcodigo/{codigofichatreino}")
    @ResponseBody
    public ResponseEntity atualizaCadastroFichaTreino (@RequestBody FichaTreino fichaTreino,
                                                 @PathVariable Integer codigoFichaTreino) {

        fichaTreinoService.atualizarCadastroFichaTreino(fichaTreino, codigoFichaTreino);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<FichaTreino> pesquisarTodosFichaTreinos() {

        return fichaTreinoRepository.findAll();

    }

    @GetMapping("pesquisar/{codigofichaTreino}")
    public FichaTreino pesquisaPorCodigo(@PathVariable Integer codigoFichaTreino) {

        return fichaTreinoService.pesquisarPorCodigoFichaTreino(codigoFichaTreino);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaFichaTreinoPorFiltro( FichaTreino filtro) {

        return fichaTreinoService.pesquisarFichaTreinoPorFiltro(filtro);
    }




}
