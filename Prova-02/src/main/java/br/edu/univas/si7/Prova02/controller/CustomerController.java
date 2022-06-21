package br.edu.univas.si7.Prova02.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.Prova02.dto.CustomerDTO;
import br.edu.univas.si7.Prova02.model.Customer;
import br.edu.univas.si7.Prova02.service.CustomerService;



@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping()
	public List<CustomerDTO> getAllCustomers() {
		return service.getAllCustomers();
	}

	@GetMapping("/{id}")
	public CustomerDTO getCustomerbyId(@PathVariable String id) {
		Customer cst = service.getCustomerbyId(id);
		return new CustomerDTO(cst);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCustomer(@RequestBody @Valid CustomerDTO dto) {
		service.createCustomer(dto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@RequestBody @Valid CustomerDTO dto, @PathVariable String id) {
		service.updateCustomer(dto, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable String id) {
		service.deleteCustomer(id);
	}
	
}
