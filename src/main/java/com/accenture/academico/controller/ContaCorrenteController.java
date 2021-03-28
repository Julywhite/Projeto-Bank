package com.accenture.academico.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.model.Agencia;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;
import com.accenture.academico.repository.AgenciaRepository;
import com.accenture.academico.service.ContaCorrenteService;
import com.accenture.academico.service.ExtratoService;


@RestController
public class ContaCorrenteController {

	@Autowired
	ContaCorrenteService contaCorrenteService;
	AgenciaRepository agenciaService;
	ExtratoService extratoService = new ExtratoService();
	 
	@GetMapping("/contaCorrente")
	private List<ContaCorrente> getAllContaCorrente() {
		return contaCorrenteService.getAllContaCorrente();
	}
	
	@GetMapping("/contaCorrente/{id}")
	private ContaCorrente getContaCorrente(@PathVariable("id") int id) {
		return contaCorrenteService.getContaCorrenteById(id);
	}
	
	@DeleteMapping("/contaCorrente/{id}")
	private void deleteContaCorrente(@PathVariable("id") int id) {
		contaCorrenteService.delete(id);
	}
	
	@PostMapping("/contaCorrente")
	private int saveContaCorrente(@RequestBody ContaCorrente contaCorrente) {
		contaCorrenteService.saveOrUpdate(contaCorrente);
		return contaCorrente.getIdContaCorrente();
	}
	
	@PostMapping("/contaCorrente/{id}/saque/{valor}")
	private void sacar(@PathVariable("id") int id, @PathVariable("valor") String valorSaque) {
		Double valorConta = Double.parseDouble(contaCorrenteService.getContaCorrenteById(id).getSaldo());
		Double valor = Double.parseDouble(valorSaque);
		
		if (valor <= valorConta) {
			
			valorConta = valorConta - valor;
			
			ContaCorrente conta = contaCorrenteService.getContaCorrenteById(id);
			conta.setSaldo(valorConta.toString());
			
			Extrato extrato = new Extrato();
			LocalDateTime dataHora = LocalDateTime.now();
			
			extrato.setDataHoraMovimento(dataHora);
			extrato.setOperacao(1);
			extrato.setContaCorrente(conta);

			extratoService.saveOrUpdate(extrato);
			contaCorrenteService.saveOrUpdate(conta);
		}
	}
}

