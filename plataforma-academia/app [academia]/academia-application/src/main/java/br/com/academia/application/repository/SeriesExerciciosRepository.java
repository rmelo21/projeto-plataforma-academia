package br.com.academia.application.repository;

import br.com.academia.application.model.SeriesExercicios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesExerciciosRepository extends JpaRepository<SeriesExercicios, Integer> {
}
