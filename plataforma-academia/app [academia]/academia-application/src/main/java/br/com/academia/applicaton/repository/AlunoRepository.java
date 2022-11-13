package br.com.academia.applicaton.repository;

import br.com.academia.applicaton.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {


    Optional<Aluno> findByIdAluno(Aluno codigoAluno);

    Optional<Aluno> delete(Integer codigoAluno);
}
