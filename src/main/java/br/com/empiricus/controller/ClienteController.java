package br.com.empiricus.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empiricus.model.Cliente;
import br.com.empiricus.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}
	
	

	@PostMapping()
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.saveCliente(cliente), HttpStatus.CREATED);
		
	}
	

	@GetMapping
	public List<Cliente> getAllClientes(){
		return clienteService.getAllClientes();
	}
	

	@GetMapping("{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") long clienteid){
		return new ResponseEntity<Cliente>(clienteService.getClienteById(clienteid), HttpStatus.OK);
	}
	

	@PutMapping("{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") long id
												,@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.updateCliente(cliente, id), HttpStatus.OK);
	}
	

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable("id") long id){

		clienteService.deleteCliente(id);
		return new ResponseEntity<String>("Cliente Deletado com sucesso!.", HttpStatus.OK);
	}
	
	
	
}
