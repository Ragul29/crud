package io.crudoperation.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

	@NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

	@NotBlank(message = "Message is mandatory")
    @Column(name = "query")
    private String query;
    
  

    public Customer() {}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getQuery() {
		return query;
	}



	public void setQuery(String query) {
		this.query = query;
	}

	public Customer(String name, String email, String query) {
		super();
		this.name = name;
		this.email = email;
		this.query = query;
	}



	


	
    

	
	}

