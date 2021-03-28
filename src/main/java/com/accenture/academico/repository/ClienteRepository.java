package com.accenture.academico.repository;

import org.springframework.data.repository.CrudRepository;
import com.accenture.academico.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
	
}

