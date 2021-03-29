package com.accenture.academico.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.repository.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {
	@Autowired
	ContaCorrenteRepository contaCorrenteRepository;

	public List<ContaCorrente> getAllContaCorrente() {
		List<ContaCorrente> contaCorrente = new ArrayList<>();
		contaCorrenteRepository.findAll().forEach(conta -> contaCorrente.add(conta));
		return contaCorrente;
	}

	public ContaCorrente getContaCorrenteById(int id) {
		return contaCorrenteRepository.findById(id).get();
	}

	public void saveOrUpdate(ContaCorrente ContaCorrente) {
		contaCorrenteRepository.save(ContaCorrente);
	}

	public void delete(int id) {
		contaCorrenteRepository.deleteById(id);
	}

}
