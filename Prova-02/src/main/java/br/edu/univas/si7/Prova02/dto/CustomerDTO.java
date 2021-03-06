package br.edu.univas.si7.Prova02.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.edu.univas.si7.Prova02.model.Customer;

public class CustomerDTO {
	
	
	private String Id;
	
	@NotNull(message = "O texto Cpf não pode ser null.")
	@NotEmpty(message = "O texto Cpf não pode ser vazio.")
	private String cpf;
	
	@NotNull(message = "O nome Name não pode ser null.")
	@NotEmpty(message = "O texto Name não pode ser vazio.")
	private String name;
	
	@NotNull(message = "O nome Birthdate não pode ser null.")
	@NotEmpty(message = "O texto Birthdate não pode ser vazio.")
	private String birthdate;
	
	@NotNull(message = "O nome Gender não pode ser null.")
	@NotEmpty(message = "O texto Gender não pode ser vazio.")
	private String gender;
	
	@NotNull(message = "O nome Email não pode ser null.")
	@NotEmpty(message = "O texto Email não pode ser vazio.")
	private String email;
	
	@NotNull(message = "O nome Loyalityrate não pode ser null.")
	@NotEmpty(message = "O texto Loyalityrate não pode ser vazio.")
	private String loyalityrate;


	public CustomerDTO() {
	}
	
	public CustomerDTO(Customer cst) {
		this.Id=cst.getId();
		this.cpf = cst.getCpf();
		this.name = cst.getName();
		this.birthdate = cst.getBirthdate();
		this.gender = cst.getGender();
		this.email = cst.getEmail();
		this.loyalityrate = cst.getLoyalityrate();
		
		
	}
	
	

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoyalityrate() {
		return loyalityrate;
	}

	public void setLoyalityrate(String loyalityrate) {
		this.loyalityrate = loyalityrate;
	}
	
}
