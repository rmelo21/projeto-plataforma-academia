package br.com.academia.application.repository;

import br.com.academia.application.model.GerarVencimentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerarVencimentosRepository extends JpaRepository<GerarVencimentos, Integer> {

}
