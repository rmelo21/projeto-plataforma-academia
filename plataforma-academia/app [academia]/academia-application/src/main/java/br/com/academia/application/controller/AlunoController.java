package br.com.academia.application.controller;

import br.com.academia.application.model.Aluno;
import br.com.academia.application.repository.AlunoRepository;
import br.com.academia.application.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private Aluno aluno;

    private AlunoService alunoService;

    private AlunoRepository alunoRepository;

    public AlunoController (AlunoRepository alunoRepository, AlunoService alunoService) {
        this.alunoRepository = alunoRepository;
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno cadastraAluno(@RequestBody Aluno aluno) {

        return alunoService.cadastrarAluno(aluno);

    }

    @DeleteMapping("/deletar/{codigoAluno}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaAlunoPorCodigo(@PathVariable Integer codigoAluno) {

        alunoService.deletarPorCodigoAluno(codigoAluno);

    }

    @PutMapping("/atualizarporcodigo/{codigoAluno}")
    @ResponseBody
    public ResponseEntity atualizaCadastroAluno ( @RequestBody Aluno aluno,
                                                  @PathVariable Integer codigoAluno) {

       alunoService.atualizarCadastroAluno(aluno, codigoAluno);

       return ResponseEntity.ok().build();
    }


    @GetMapping("/pesquisar")
    @ResponseBody
    public List<Aluno> pesquisarTodosAlunos() {

        return alunoRepository.findAll();

    }

    @GetMapping("pesquisar/{codigoAluno}")
    public Aluno pesquisaPorCodigo(@PathVariable Integer codigoAluno) {

        return alunoService.pesquisarPorCodigoAluno(codigoAluno);

    }

    @GetMapping("pesquisar/filtro")
    @ResponseBody
    public ResponseEntity pesquisaAlunoPorFiltro( Aluno filtro) {

        return alunoService.pesquisarAlunoPorFiltro(filtro);
    }


}
