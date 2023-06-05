
package com.contacts.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.app.dto.ContactDto;
import com.contacts.app.entities.Contact;
import com.contacts.app.service.ContactService;

@RequestMapping("v1/cms")
@RestController
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/contacts")
	public ResponseEntity<ContactDto> addContact(@Valid @RequestBody ContactDto contactDto) {
		Contact contact = modelMapper.map(contactDto, Contact.class);
		contact.setSeq(null);
		contact = contactService.addContact(contact);
		contactDto = modelMapper.map(contact, ContactDto.class);
		return ResponseEntity.ok(contactDto);
	}
	
	// problem in update
	@GetMapping("/contacts")
	public ResponseEntity<List<ContactDto>> getContacts() {
		List<Contact> contacts = contactService.getContacts();
		List<ContactDto> contactsDtoList = new ArrayList();
		for(Contact contact : contacts) {
			contactsDtoList.add(modelMapper.map(contact, ContactDto.class));
		}
		return ResponseEntity.ok(contactsDtoList);
	}
	
	
	@PutMapping("/contacts/{seq}")
	public ResponseEntity<ContactDto> updateContact(
			@PathVariable("seq") Long seq, 
			@Valid @RequestBody ContactDto contactDto) {
		contactDto.setSeq(seq);
		Contact contact = modelMapper.map(contactDto, Contact.class);
		Contact updatedContact = contactService.updateContact(seq, contact);
		return ResponseEntity.ok(modelMapper.map(updatedContact, ContactDto.class));
	}
	
	
	@GetMapping("/contacts/search")
	public ResponseEntity<List<ContactDto>> searchContacts(
			@RequestParam(name="firstName", required = false) String firstName, 
			@RequestParam(name="lastName", required = false) String lastName, 
			@RequestParam(name="email", required = false) String email) {
		
		List<ContactDto> contactsDtoList = new ArrayList();
		List<Contact> contacts = contactService.searchContact(firstName, lastName, email);
		for(Contact contact : contacts) {
			System.out.println(contact);
			contactsDtoList.add(modelMapper.map(contact, ContactDto.class));
		}
		return ResponseEntity.ok(contactsDtoList);
	}
	
	@DeleteMapping("/contacts/{seq}")
	public void deleteContact(@PathVariable("seq") Long seq) {
		contactService.deleteContact(seq);
	}
}
