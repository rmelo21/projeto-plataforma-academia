package br.com.academia.application.controller;

import br.com.academia.application.model.Exercicios;
import br.com.academia.application.repository.ExerciciosRepository;
import br.com.academia.application.service.ExerciciosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercicios")
public class ExerciciosController {

    private Exercicios exercicios;
    
    private ExerciciosService exerciciosService;
    
    private ExerciciosRepository exerciciosRepository;
    
    public ExerciciosController (ExerciciosService exerciciosService, ExerciciosRepository exerciciosRepository) {
        this.exerciciosService = exerciciosService;
        this.exerciciosRepository = exerciciosRepository;        
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Exercicios cadastraExercicios(@RequestBody Exercicios exercicios) {

        return exerciciosService.cadastrarExercicios(exercicios);

    }

    @DeleteMapping("/deletar/{codigoExercicios}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaExerciciosPorCodigo(@PathVariable Integer codigoExercicios) {

        exerciciosService.deletarPorCodigoExercicios(codigoExercicios);

    }

    @PutMapping("/atualizarporcodigo/{codigoExercicios}")
    @ResponseBody
    public ResponseEntity atualizaCadastroExercicios (@RequestBody Exercicios exercicios,
                                                 @PathVariable Integer codigoExercicios) {

        exerciciosService.atualizarCadastroExercicios(exercicios, codigoExercicios);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<Exercicios> pesquisarTodosExercicios() {

        return exerciciosRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoExercicios}")
    public Exercicios pesquisaPorCodigo(@PathVariable Integer codigoExercicios) {

        return exerciciosService.pesquisarPorCodigoExercicios(codigoExercicios);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaExerciciosPorFiltro( Exercicios filtro) {

        return exerciciosService.pesquisarExerciciosPorFiltro(filtro);
    }




}
