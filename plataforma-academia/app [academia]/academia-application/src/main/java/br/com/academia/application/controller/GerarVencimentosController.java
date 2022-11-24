package br.com.academia.application.controller;


import br.com.academia.application.model.GerarVencimentos;
import br.com.academia.application.repository.GerarVencimentosRepository;
import br.com.academia.application.service.GerarVencimentosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gerarvencimentos")
public class GerarVencimentosController {

    private GerarVencimentos gerarVencimentos;

    private GerarVencimentosService gerarVencimentosService;

    private GerarVencimentosRepository gerarVencimentosRepository;


    public GerarVencimentosController(GerarVencimentosService gerarVencimentosService, GerarVencimentosRepository gerarVencimentosRepository) {
        this.gerarVencimentosService = gerarVencimentosService;
        this.gerarVencimentosRepository = gerarVencimentosRepository;
    }


}
