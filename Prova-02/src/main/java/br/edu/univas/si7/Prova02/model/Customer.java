package br.edu.univas.si7.Prova02.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Customer {
	
	@org.springframework.data.annotation.Id
	private String Id;

	private String cpf;
	private String name;
	private String birthdate;
	private String gender;
	private String email;
	private String loyalityrate;
	
	  @DBRef(lazy = true)
	    private Auditing auditing;


	public Customer() {
	}

	public Customer(String Id,String cpf, String name, String birthdate,String gender,String email,String loyalityrate) {
		super();
		this.Id=Id;
		this.cpf = cpf;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.email = cpf;
		this.loyalityrate=loyalityrate;
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

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Auditing getAuditing() {
		return auditing;
	}

	public void setAuditing(Auditing auditing) {
		this.auditing = auditing;
	}
	
}
