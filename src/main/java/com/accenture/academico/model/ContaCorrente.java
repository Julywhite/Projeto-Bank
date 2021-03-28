package com.accenture.academico.model;


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
public class ContaCorrente {

	@Id
	@GeneratedValue(generator="seq_contacorrente_id",strategy= GenerationType.SEQUENCE)
	private int id;

	@Column
	@NotBlank
	private String numero;
	
	@Column
	@NotBlank
	private String saldo;
	
	@OneToOne
	private Agencia agencia;
	
	@OneToOne
	private Cliente cliente;
	

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

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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





}