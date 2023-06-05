package com.contacts.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacts.app.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

	List<Contact> findByFirstNameOrLastNameOrEmail(String firstName, String lastName, String email);
}
