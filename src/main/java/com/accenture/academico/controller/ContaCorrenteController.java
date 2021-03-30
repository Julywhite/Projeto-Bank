package com.accenture.academico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.service.ContaCorrenteService;
import com.accenture.academico.service.ExtratoService;

@RestController
public class ContaCorrenteController {

	@Autowired
	ContaCorrenteService contaCorrenteService;

	@Autowired
	ExtratoService extratoService;

	@GetMapping("/contaCorrente")
	public List<ContaCorrente> getAllContaCorrente() {
		return contaCorrenteService.getAllContaCorrente();
	}

	@GetMapping("/contaCorrente/{id}")
	public ContaCorrente getContaCorrente(@PathVariable("id") int id) {
		return contaCorrenteService.getContaCorrenteById(id);
	}

	@PostMapping("/contaCorrente/{id}/reconstruirSaldo")
	public ContaCorrente reconstruirSaldo(@PathVariable("id") int id) {
		return contaCorrenteService.reconstruirSaldoExtratos(id);
	}

	@GetMapping("/contaCorrente/{id}/validaSaldo")
	public String validaSaldo(@PathVariable("id") int id) {
		return contaCorrenteService.validaSaldoExtratos(id);
	}

	@DeleteMapping("/contaCorrente/{id}")
	public void deleteContaCorrente(@PathVariable("id") int id) {
		contaCorrenteService.delete(id);
	}

	@PostMapping("/contaCorrente")
	public int saveContaCorrente(@RequestBody ContaCorrente contaCorrente) {
		contaCorrenteService.saveOrUpdate(contaCorrente);
		return contaCorrente.getIdContaCorrente();
	}

	@PostMapping("/contaCorrente/{id}/saque/{valor}")
	public void sacar(@PathVariable("id") int id, @PathVariable("valor") Double valorSaque) {
		contaCorrenteService.sacar(id, valorSaque);
	}

	@PostMapping("/contaCorrente/{id}/deposito/{valor}")
	public void depositar(@PathVariable("id") int id, @PathVariable("valor") Double valorDeposito) {
		contaCorrenteService.depositar(id, valorDeposito);
	}

	@PostMapping("/contaCorrente/{id}/transferencia/{valor}/{id2}")
	public void transferir(@PathVariable("id") int id, @PathVariable("valor") Double valorTransferencia,
			@PathVariable("id2") int id2) {
		contaCorrenteService.transferir(id, valorTransferencia, id2);
	}
}
