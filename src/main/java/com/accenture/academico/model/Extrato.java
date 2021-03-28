package com.accenture.academico.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Extrato {

	@Id
	@GeneratedValue(generator="seq_extrato_id",strategy= GenerationType.SEQUENCE)
	@Column
	private int id;

	@Column
	@NotBlank
	private LocalDateTime DataHoraMovimento;

	@Column
	@NotBlank
	private int operacao;
	
	@OneToOne
	private ContaCorrente contaCorrente;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraMovimento() {
		return DataHoraMovimento;
	}

	public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
		DataHoraMovimento = dataHoraMovimento;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}


}
