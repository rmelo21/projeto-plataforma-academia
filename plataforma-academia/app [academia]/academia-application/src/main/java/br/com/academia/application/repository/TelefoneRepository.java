package br.com.academia.application.repository;

import br.com.academia.application.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

}
