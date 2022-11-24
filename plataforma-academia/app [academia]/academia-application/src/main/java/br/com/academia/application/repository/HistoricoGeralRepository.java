package br.com.academia.application.repository;

import br.com.academia.application.model.HistoricoGeral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoGeralRepository extends JpaRepository<HistoricoGeral, Integer> {
}
