package com.accenture.academico.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.Agencia;
import com.accenture.academico.repository.AgenciaRepository;

@Service
public class AgenciaService {
	@Autowired
	AgenciaRepository agenciaRepository;

	public List<Agencia> getAllAgencia() {
		List<Agencia> agencia = new ArrayList<Agencia>();
		agenciaRepository.findAll().forEach(Ag -> agencia.add(Ag));
		return agencia;
	}

	public Agencia getAgenciaById(int id) {
		return agenciaRepository.findById(id).get();
	}

	public void saveOrUpdate(Agencia Agencia) {
		agenciaRepository.save(Agencia);
	}

	public void delete(int id) {
		agenciaRepository.deleteById(id);
	}
}
