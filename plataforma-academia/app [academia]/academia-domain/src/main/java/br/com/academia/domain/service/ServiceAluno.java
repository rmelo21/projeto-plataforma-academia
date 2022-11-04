//package br.com.academia.domain.service;
//
//import br.com.academia.domain.model.Aluno;
//import br.com.academia.domain.repository.AlunoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ServiceAluno {
//
//    @Autowired
//    private AlunoRepository alunoRepository;
//
//    @Autowired
//    private Aluno aluno;
//
//    public Aluno cadastrarAluno( Aluno aluno) {
//
//        return alunoRepository.save(aluno);
//    }
//
//
//    public List<Aluno> pesquisarAluno(Aluno aluno) {
//
//        return alunoRepository.findAll();
//    }
//}
