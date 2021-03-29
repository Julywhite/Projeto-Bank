package com.accenture.academico.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.exceptions.InsufficientFundsException;
import com.accenture.academico.exceptions.InvalidDepositeValueException;
import com.accenture.academico.exceptions.InvalidOperationException;
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
	
	public void transferir(int id, Double valorTransferencia, int id2) {
		ContaCorrente contaDoadora = getContaCorrenteById(id);
		ContaCorrente contaRecebedora = getContaCorrenteById(id2);
		Double valorContaD = contaDoadora.getSaldo();
		Double valorContaR = contaRecebedora.getSaldo();
		
		if (valorTransferencia <= valorContaD) {
			
			contaDoadora.setSaldo(valorContaD - valorTransferencia);
			contaRecebedora.setSaldo(valorContaR + valorTransferencia);
			
			Extrato extrato1 = new Extrato();
			
			extrato1.setDataHoraMovimento(LocalDateTime.now());
			extrato1.setOperacao(Extrato.TRANSF_DEBITO);
			extrato1.setContaCorrente(contaDoadora);
			extrato1.setValor(valorTransferencia);
			
			extratoService.saveOrUpdate(extrato1);
			saveOrUpdate(contaDoadora);
			
			Extrato extrato2 = new Extrato();
			
			extrato2.setDataHoraMovimento(LocalDateTime.now());
			extrato2.setOperacao(Extrato.TRANSF_CREDITO);
			extrato2.setContaCorrente(contaRecebedora);
			extrato2.setValor(valorTransferencia);
			
			extratoService.saveOrUpdate(extrato2);
			saveOrUpdate(contaRecebedora);
			
		}else {
			throw new InvalidOperationException("Não foi possível realizar Transferência. Operação inválida.");
		}
	}

}
