package br.com.academia.applicaton.controller;

import br.com.academia.applicaton.model.Aluno;
import br.com.academia.applicaton.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private Aluno aluno;

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/cadastrar")
    @ResponseStatus
    public HttpStatus cadastraAluno(@RequestBody Aluno aluno) {

        return alunoService.cadastrarAluno(aluno);

    }

    @GetMapping("pesquisar/{codigoAluno}")
    @ResponseStatus
    public Aluno pesquisaPorCodigo(@PathVariable Integer codigoAluno) {

        return alunoService.pesquisarPorCodigoAluno(aluno);
    }

    @DeleteMapping("/deletar/{codigoAluno}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Aluno deletaAlunoPorCodigo (@PathVariable Integer codigoAluno) {

        return alunoService.deletarPorCodigoAluno(codigoAluno);
    }

    @PutMapping("/atualizar/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Aluno atualizaAlunoPorCodigo(@PathVariable Integer codigoAluno,
                                                  @RequestBody Aluno aluno) {

        return alunoService.atualizarAlunoPorCodigo(aluno);

    }

    @GetMapping("pesquisar/filtro")
    public List<Aluno> pesquisaAlunoPorFiltro (@RequestBody Aluno aluno) {

        return alunoService.pesquisarAlunoPorFiltro(aluno);
    }
}
