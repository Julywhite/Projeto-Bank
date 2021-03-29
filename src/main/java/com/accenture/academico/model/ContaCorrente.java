package com.accenture.academico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class ContaCorrente {

	@Id
	@GeneratedValue(generator = "seq_contacorrente_id", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column
	@NotBlank
	private String numero;

	@Column
	@NotNull
	private Double saldo;

	@ManyToOne
	@JoinColumn(name = "id_agencia")
	private Agencia agencia;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdContaCorrente() {
		return id;
	}

	public void setIdContaCorrente(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getIdAgencia() {
		return this.agencia.getId();
	}
	
	public void setIdAgencia(int idAgencia) {
		this.agencia.setId(idAgencia);
	}
	
	public int getIdCliente() {
		return this.cliente.getId();
	}
	
	public void setIdCliente(int idCliente) {
		this.cliente.setId(idCliente);
	}

}