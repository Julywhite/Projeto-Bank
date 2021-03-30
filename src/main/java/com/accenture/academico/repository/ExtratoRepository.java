package com.accenture.academico.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;

public interface ExtratoRepository extends CrudRepository<Extrato, Integer> {

	List<Extrato> findAll();

	List<Extrato> findAllByContaCorrente(ContaCorrente ContaCorrente);

}
