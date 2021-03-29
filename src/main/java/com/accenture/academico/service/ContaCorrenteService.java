package com.accenture.academico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.exceptions.InsufficientFundsException;
import com.accenture.academico.exceptions.InvalidDepositeValueException;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;
import com.accenture.academico.repository.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {
	@Autowired
	ContaCorrenteRepository contaCorrenteRepository;
	@Autowired
	ExtratoService extratoService;

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
	
	public void sacar(int id, Double valor) {
		ContaCorrente conta = getContaCorrenteById(id);
		
		if (valor <= conta.getSaldo())  {
			
			Double saldoAtual = conta.getSaldo() - valor;
			conta.setSaldo(saldoAtual);
			
			Extrato extrato = new Extrato();
			
			extrato.setDataHoraMovimento(LocalDateTime.now());
			extrato.setOperacao(Extrato.SAQUE);
			extrato.setContaCorrente(conta);
			extrato.setValor(valor);

			extratoService.saveOrUpdate(extrato);
			saveOrUpdate(conta);
			
		}else {
			throw new InsufficientFundsException("Não foi possível sacar. Fundos insuficientes.");
		}
	}
	
	public void depositar(int id, Double valorDeposito) {
		ContaCorrente conta = getContaCorrenteById(id);
		Double valorConta = conta.getSaldo();
		
		if (valorDeposito > 0) {
			
			conta.setSaldo(valorConta + valorDeposito);
			
			Extrato extrato = new Extrato();
			
			extrato.setDataHoraMovimento(LocalDateTime.now());
			extrato.setOperacao(Extrato.DEPOSITO);
			extrato.setContaCorrente(conta);
			extrato.setValor(valorDeposito);

			extratoService.saveOrUpdate(extrato);
			saveOrUpdate(conta);
			
		}else {
			throw new InvalidDepositeValueException("Não foi possível depositar. Valor inválido.");
		}
	}

}
