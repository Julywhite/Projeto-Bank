package com.accenture.academico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.model.Cliente;
import com.accenture.academico.service.ClienteService;


@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	 
	@GetMapping("/cliente")
	private List<Cliente> getAllCliente() {
		return clienteService.getAllCliente();
	}
	
	@GetMapping("/cliente/{id}")
	private Cliente getCliente(@PathVariable("id") int id) {
		return clienteService.getClienteById(id);
	}
	
	@DeleteMapping("/cliente/{id}")
	private void deleteCliente(@PathVariable("id") int id) {
		clienteService.delete(id);
	}
	
	@PostMapping("/cliente")
	private int saveCliente(@RequestBody Cliente cliente) {
		clienteService.saveOrUpdate(cliente);
		return cliente.getId();
	}
	
}

