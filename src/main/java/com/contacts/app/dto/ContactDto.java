package com.contacts.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContactDto {
	
	private Long seq;
	
	@NotNull(message= "First Name should not be null")
	@Size(min=2, max=100, message="First Name should have atleast 2 characters and mximum 100 characters")
	private String firstName;
	
	private String lastName;
	
	@NotNull(message= "Email should not be null")
	@Email(message="Email should be valid")
	private String email;
	
	@NotNull(message= "Phone Number should not be null")
	@Size(min=10, max=100, message="Phone Number should have atleast of 10 characters and mximum 20 chcracters")
	private String phoneNumber;
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
