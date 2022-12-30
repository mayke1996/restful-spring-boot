package br.com.mayke.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mayke.exceptions.ResourceNotFoundException;
import br.com.mayke.model.Person;
import br.com.mayke.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public List<Person> findAll() {
		logger.info("Finding all people");
		return repository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}

}