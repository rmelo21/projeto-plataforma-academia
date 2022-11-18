package br.com.academia.application.controller;

import br.com.academia.application.model.matricula;
import br.com.academia.application.model.Matricula;
import br.com.academia.application.repository.MatriculaRepository;
import br.com.academia.application.service.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaController {
    
    private Matricula matricula;
    
    private MatriculaService matriculaService;
    
    private MatriculaRepository matriculaRepository;


    public MatriculaController(MatriculaService matriculaService, MatriculaRepository matriculaRepository) {
        this.matriculaService = matriculaService;
        this.matriculaRepository = matriculaRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Matricula cadastramatricula(@RequestBody Matricula matricula) {

        return matriculaService.cadastrarMatricula(matricula);

    }

    @DeleteMapping("/deletar/{codigomatricula}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaMatriculaPorCodigo(@PathVariable Integer codigoMatricula) {

        matriculaService.deletarPorCodigoMatricula(codigoMatricula);

    }

    @PutMapping("/atualizarporcodigo/{codigomatricula}")
    @ResponseBody
    public ResponseEntity atualizaCadastroMatricula (@RequestBody Matricula matricula,
                                                 @PathVariable Integer codigoMatricula) {

        matriculaService.atualizarCadastroMatricula(matricula, codigoMatricula);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<Matricula> pesquisarTodosMatriculas() {

        return matriculaRepository.findAll();

    }

    @GetMapping("pesquisar/{codigomatricula}")
    public Matricula pesquisaPorCodigo(@PathVariable Integer codigoMatricula) {

        return matriculaService.pesquisarPorCodigoMatricula(codigoMatricula);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaMatriculaPorFiltro( Matricula filtro) {

        return matriculaService.pesquisarMatriculaPorFiltro(filtro);
    }


}
