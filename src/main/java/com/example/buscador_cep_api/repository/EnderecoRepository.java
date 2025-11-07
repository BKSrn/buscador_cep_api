package com.example.buscador_cep_api.repository;

import com.example.buscador_cep_api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
