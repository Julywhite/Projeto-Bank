package com.accenture.academico.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Extrato {

	@Transient
	public static final int TESTE = 0;
	@Transient
	public static final int SAQUE = 1;
	@Transient
	public static final int DEPOSITO = 2;
	@Transient
	public static final int TRANSF_DEBITO = 3;
	@Transient
	public static final int TRANSF_CREDITO = 4;

	@Id
	@GeneratedValue(generator = "seq_extrato_id", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column
	@NotNull
	private LocalDateTime dataHoraMovimento;

	@Column
	@NotNull
	private int operacao;
	
	@Column
	@NotNull
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "id_contacorrente")
	private ContaCorrente contaCorrente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraMovimento() {
		return dataHoraMovimento;
	}

	public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	public int getIdContaCorrente() {
		return this.contaCorrente.getId();
	}
	
	public void setIdContaCorrente(int idContaCorrente) {
		this.contaCorrente.setId(idContaCorrente);
	}

}
