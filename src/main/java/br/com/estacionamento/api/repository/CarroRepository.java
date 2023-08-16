package br.com.estacionamento.api.repository;

import br.com.estacionamento.api.model.Carro;
import br.com.estacionamento.api.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
