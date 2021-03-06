package br.edu.univas.si7.Prova02.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.univas.si7.Prova02.dto.CustomerDTO;
import br.edu.univas.si7.Prova02.model.Auditing;
import br.edu.univas.si7.Prova02.model.Customer;
import br.edu.univas.si7.Prova02.repository.AuditingMongoRepository;
import br.edu.univas.si7.Prova02.repository.CustomerMongoRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerMongoRepository cstREPO;
	
	@Autowired
	private AuditingMongoRepository audRepo;
	
	
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> listMSG = cstREPO.findAll();
		return listMSG.stream()
				.map(cst -> new CustomerDTO(cst))
				.collect(Collectors.toList());
	}
	
	public void createCustomer(CustomerDTO dto) {
		Customer cst = toCustomer(dto);
		Auditing adt = new Auditing();
		adt.setOperation("CREATE");
		adt.setDate(LocalDateTime.now());
		audRepo.save(adt);
		cst.setAuditing(adt);
		cstREPO.save(cst);
		
	}
		
		public Customer getCustomerbyId(@PathVariable String id) {
			Optional<Customer> obj = cstREPO.findById(id);
			return obj.get();
		}
	

	public void updateCustomer(CustomerDTO dto, String id) {
		Customer cst = getCustomerbyId(id);
		updateData(dto, cst);
		Auditing adt = new Auditing();
		adt.setOperation("update");
		adt.setDate(LocalDateTime.now());
		audRepo.save(adt);
		cst.setAuditing(adt);
		cstREPO.save(cst);
	}

	public void deleteCustomer(String id) {
		Customer cst = getCustomerbyId(id);
		Auditing adt = new Auditing();
		adt.setOperation("delete");
		adt.setDate(LocalDateTime.now());
		audRepo.save(adt);
		cst.setAuditing(adt);
		cstREPO.delete(cst);
	}

	private void updateData(CustomerDTO dto, Customer cst) {
		cst.setBirthdate(dto.getBirthdate());
		cst.setCpf(dto.getCpf());
		cst.setEmail(dto.getEmail());
		cst.setGender(dto.getGender());
		cst.setLoyalityrate(dto.getLoyalityrate());
		cst.setName(dto.getName());
	}
	
	private Customer toCustomer(CustomerDTO dto) {
		Customer cst = new Customer();
		cst.setCpf(dto.getCpf());
		cst.setBirthdate(dto.getBirthdate());
		cst.setEmail(dto.getEmail());
		cst.setGender(dto.getGender());
		cst.setLoyalityrate(dto.getLoyalityrate());
		cst.setName(dto.getName());
		
		return cst;
	}

}
