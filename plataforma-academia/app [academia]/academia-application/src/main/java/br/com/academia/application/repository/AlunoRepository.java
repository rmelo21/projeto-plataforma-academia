package br.com.academia.application.repository;

import br.com.academia.application.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoRepository extends JpaRepository<Aluno, Integer> {


}
