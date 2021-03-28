package com.accenture.academico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.model.Extrato;
import com.accenture.academico.service.ExtratoService;


@RestController
public class ExtratoController {

	@Autowired
	ExtratoService extratoService;
	 
	@GetMapping("/extrato")
	private List<Extrato> getAllExtrato() {
		return extratoService.getAllExtrato();
	}
	
	@GetMapping("/extrato/{id}")
	private Extrato getExtrato(@PathVariable("id") int id) {
		return extratoService.getExtratoById(id);
	}
	
	@PostMapping("/extrato")
	private int saveExtrato(@RequestBody Extrato extrato) {
		extratoService.saveOrUpdate(extrato);
		return extrato.getId();
	}

}

