package br.com.academia.application.repository;

import br.com.academia.application.model.Exercicios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciciosRepository extends JpaRepository<Exercicios, Integer> {

}
