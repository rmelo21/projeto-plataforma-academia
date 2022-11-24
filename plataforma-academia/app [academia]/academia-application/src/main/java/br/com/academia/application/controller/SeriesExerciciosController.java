package br.com.academia.application.controller;


import br.com.academia.application.model.SeriesExercicios;
import br.com.academia.application.repository.SeriesExerciciosRepository;
import br.com.academia.application.service.SeriesExerciciosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seriesexercicios")
public class SeriesExerciciosController {
    
    private SeriesExercicios seriesExercicios;
    
    private SeriesExerciciosService seriesExerciciosService;
    
    private SeriesExerciciosRepository seriesExerciciosRepository;


    public SeriesExerciciosController(SeriesExerciciosService seriesExerciciosService, SeriesExerciciosRepository seriesExerciciosRepository) {
        this.seriesExerciciosService = seriesExerciciosService;
        this.seriesExerciciosRepository = seriesExerciciosRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public SeriesExercicios cadastraSeriesExercicios(@RequestBody SeriesExercicios seriesExercicios) {

        return seriesExerciciosService.cadastrarSeriesExercicios(seriesExercicios);

    }

    @DeleteMapping("/deletar/{codigoSeriesExercicios}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaSeriesExerciciosPorCodigo(@PathVariable Integer codigoSeriesExercicios) {

        seriesExerciciosService.deletarPorCodigoSeriesExercicios(codigoSeriesExercicios);

    }

    @PutMapping("/atualizarporcodigo/{codigoSeriesExercicios}")
    @ResponseBody
    public ResponseEntity atualizaCadastroSeriesExercicios (@RequestBody SeriesExercicios seriesExercicios,
                                                 @PathVariable Integer codigoSeriesExercicios) {

        seriesExerciciosService.atualizarCadastroSeriesExercicios(seriesExercicios, codigoSeriesExercicios);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<SeriesExercicios> pesquisarTodosSeriesExercicioss() {

        return seriesExerciciosRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoSeriesExercicios}")
    public SeriesExercicios pesquisaPorCodigo(@PathVariable Integer codigoSeriesExercicios) {

        return seriesExerciciosService.pesquisarPorCodigoSeriesExercicios(codigoSeriesExercicios);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaSeriesExerciciosPorFiltro( SeriesExercicios filtro) {

        return seriesExerciciosService.pesquisarSeriesExerciciosPorFiltro(filtro);
    }


}
