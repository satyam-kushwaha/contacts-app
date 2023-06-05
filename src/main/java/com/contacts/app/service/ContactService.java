package com.contacts.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.contacts.app.entities.Contact;
import com.contacts.app.exception.ResourceNotFoundException;
import com.contacts.app.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public Contact addContact(Contact contact) {
		contact = contactRepository.save(contact);
		return contact;
	}
	
	public List<Contact> getContacts() {
//		int defaultPageSize = 5;
//		Pageable pageable = PageRequest.of(defaultPageSize, size);
		return (List<Contact>) contactRepository.findAll();
	}
	
	public List<Contact> searchContact(String firstName, String lastName, String email){
		return contactRepository.findByFirstNameOrLastNameOrEmail(firstName, lastName, email);
	}
	
	public void deleteContact(Long seq){
		contactRepository.findById(seq)
		.orElseThrow(()-> new ResourceNotFoundException("Contact is not found with id : "+seq));
		contactRepository.deleteById(seq);
	}
	
	public Contact updateContact(Long seq, Contact contact) {
		contactRepository.findById(seq)
		.orElseThrow(()-> new ResourceNotFoundException("Contact is not found with id : "+seq));
		contact = contactRepository.save(contact);
		return contact;
	}
}
