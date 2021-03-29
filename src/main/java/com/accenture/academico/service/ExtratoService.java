package com.accenture.academico.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.Extrato;
import com.accenture.academico.repository.ExtratoRepository;

@Service
public class ExtratoService {
	@Autowired
	ExtratoRepository extratoRepository;

	public List<Extrato> getAllExtrato() {
		List<Extrato> extrato = new ArrayList<>();
		extratoRepository.findAll().forEach(extrat -> extrato.add(extrat));
		return extrato;
	}

	public Extrato getExtratoById(int id) {
		return extratoRepository.findById(id).get();
	}

	public void saveOrUpdate(Extrato extrato) {
		extratoRepository.save(extrato);
	}
}
