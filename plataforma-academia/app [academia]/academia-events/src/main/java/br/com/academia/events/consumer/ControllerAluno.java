package br.com.academia.events.consumer;

import br.com.academia.domain.model.Aluno;
import br.com.academia.domain.ports.in.ProcessarEventoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("api/aluno")

public class ControllerAluno {

    @Autowired
    private ProcessarEventoPort processarEventoPort;

    @Autowired
    private Aluno aluno;

//    @Autowired
//    private ServiceAluno serviceAluno;

    @RequestMapping(value = "/hello/{nome}", method = GET)
    @ResponseBody
    public String helloAluno (@PathVariable("nome") String nome) {
        return  String.format("Hello %s", nome);
    }

//    @PostMapping("/cadastrar")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Aluno> cadastraAluno(@RequestBody Aluno aluno) {
//
//        processarEventoPort.validarAluno(aluno);
//
//        return ResponseEntity.badRequest().body(aluno);
//    }
//
//    @GetMapping("/{CODIGO}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<Aluno>> pesquisaAluno(@RequestBody Aluno aluno) {
//
//        serviceAluno.pesquisarAluno(aluno);
//
//        return ResponseEntity.ok().body(serviceAluno.pesquisarAluno(aluno));
//
//    }

}
