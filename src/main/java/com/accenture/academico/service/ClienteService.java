package com.accenture.academico.service;

import java.util.ArrayList;
import java.util.List;

import com.accenture.academico.utils.DocValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.model.Cliente;
import com.accenture.academico.repository.ClienteRepository;


@Service
public class ClienteService 
{
	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> getAllCliente() 
	{
		List<Cliente> clients = new ArrayList<Cliente>();
		clienteRepository.findAll().forEach(cliente -> clients.add(cliente));
		return clients;
	}


	public Cliente getClienteById(int id) {
		return clienteRepository.findById(id).get();
	}
	
	public void saveOrUpdate(Cliente cliente) {

		DocValidation.checkCPF(cliente);
		clienteRepository.save(cliente);
	}

	public void delete(int id) {
		clienteRepository.deleteById(id);
	}
}
