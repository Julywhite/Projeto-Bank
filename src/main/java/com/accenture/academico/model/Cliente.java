package com.accenture.academico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cliente 
{

	@Id
	@GeneratedValue(generator="seq_cliente_id",strategy= GenerationType.SEQUENCE)
	private int id;

	@Column
	private String nome;

	@Column
	private Long cpf;

	@Column
	private Long fone;
	
//	@OneToMany
//	@JoinColumn(name = "idCliente")
//	private List<ContaCorrente> contasCliente;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public Long getFone() {
		return fone;
	}
	public void setFone(Long fone) {
		this.fone = fone;
	}
//	public List<ContaCorrente> getContasCliente() {
//		return contasCliente;
//	}
//	public void setContas(List<ContaCorrente> contasCliente) {
//		this.contasCliente = contasCliente;
//	}
	
}
