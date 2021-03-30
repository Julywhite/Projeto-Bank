package com.accenture.academico.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;
import com.accenture.academico.repository.ExtratoRepository;

@Service
public class ExtratoService {
	@Autowired
	ExtratoRepository extratoRepository;

	public List<Extrato> getAllExtrato() {
		return extratoRepository.findAll();
	}

	public List<Extrato> getAllExtratoByContaCorrente(ContaCorrente contaCorrente) {
		return extratoRepository.findAllByContaCorrente(contaCorrente);
	}

	public Extrato getExtratoById(int id) {
		return extratoRepository.findById(id).get();
	}

	public void saveOrUpdate(Extrato extrato) {
		extratoRepository.save(extrato);
	}

	public Double saldoReconstruido(ContaCorrente contaCorrente) {
		Double novoSaldo = 0.0;
		for (Extrato ex : getAllExtratoByContaCorrente(contaCorrente)) {
			if (ex.getOperacao() == Extrato.DEPOSITO || ex.getOperacao() == Extrato.TRANSF_CREDITO) {
				novoSaldo += ex.getValor();
			} else if (ex.getOperacao() == Extrato.SAQUE || ex.getOperacao() == Extrato.TRANSF_DEBITO) {
				novoSaldo -= ex.getValor();
			}
		}
		return novoSaldo;
	}
}
