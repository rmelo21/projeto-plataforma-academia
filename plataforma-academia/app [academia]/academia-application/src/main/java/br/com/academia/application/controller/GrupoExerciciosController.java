package br.com.academia.application.controller;

import br.com.academia.application.model.GrupoExercicios;
import br.com.academia.application.repository.GrupoExerciciosRepository;
import br.com.academia.application.service.GrupoExerciciosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupoexercicios")
public class GrupoExerciciosController {
    
    private GrupoExercicios grupoExercicios;
    
    private GrupoExerciciosService grupoExerciciosService;
    
    private GrupoExerciciosRepository grupoExerciciosRepository;


    public GrupoExerciciosController(GrupoExerciciosService grupoExerciciosService, GrupoExerciciosRepository grupoExerciciosRepository) {
        this.grupoExerciciosService = grupoExerciciosService;
        this.grupoExerciciosRepository = grupoExerciciosRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoExercicios cadastragrupoExercicios(@RequestBody GrupoExercicios grupoExercicios) {

        return grupoExerciciosService.cadastrarGrupoExercicios(grupoExercicios);

    }

    @DeleteMapping("/deletar/{codigoGrupoExercicios}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaGrupoExerciciosPorCodigo(@PathVariable Integer codigoGrupoExercicios) {

        grupoExerciciosService.deletarPorCodigoGrupoExercicios(codigoGrupoExercicios);

    }

    @PutMapping("/atualizarporcodigo/{codigoGrupoExercicios}")
    @ResponseBody
    public ResponseEntity atualizaCadastroGrupoExercicios (@RequestBody GrupoExercicios grupoExercicios,
                                                 @PathVariable Integer codigoGrupoExercicios) {

        grupoExerciciosService.atualizarCadastroGrupoExercicios(grupoExercicios, codigoGrupoExercicios);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<GrupoExercicios> pesquisarTodosgrupoExercicioss() {

        return grupoExerciciosRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoGrupoExercicios}")
    public GrupoExercicios pesquisaPorCodigo(@PathVariable Integer codigoGrupoExercicios) {

        return grupoExerciciosService.pesquisarPorCodigoGrupoExercicios(codigoGrupoExercicios);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisagrupoExerciciosPorFiltro( GrupoExercicios filtro) {

        return grupoExerciciosService.pesquisarGrupoExerciciosPorFiltro(filtro);
    }


}
