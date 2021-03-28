package com.accenture.academico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.model.Agencia;
import com.accenture.academico.service.AgenciaService;


@RestController
public class AgenciaController {

	@Autowired
	AgenciaService agenciaService;
	 
	@GetMapping("/agencia")
	private List<Agencia> getAllAgencia() {
		return agenciaService.getAllAgencia();
	}
	
	@GetMapping("/agencia/{id}")
	private Agencia getAgencia(@PathVariable("id") int id) {
		return agenciaService.getAgenciaById(id);
	}
	
	@DeleteMapping("/agencia/{id}")
	private void deleteAgencia(@PathVariable("id") int id) {
		agenciaService.delete(id);
	}
	
	@PostMapping("/agencia")
	private int saveAgencia(@RequestBody Agencia agencia) {
		agenciaService.saveOrUpdate(agencia);
		return agencia.getId();
	}
}

