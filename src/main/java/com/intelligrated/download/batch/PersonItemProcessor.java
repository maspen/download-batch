package com.intelligrated.download.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Simple transformer that converts names to uppercase.
 * 
 * ItemProcessor<Person, Person> is an interface. Here, we're
 * indicating that the interface take in a Person object and returns a Person object.
 * These do NOT have to be the same.
 * 
 * @author matt.aspen
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	@Override
	public Person process(Person person) throws Exception {
		final String firstName = person.getFirstName().toUpperCase();
		final String lastname = person.getLastName().toUpperCase();
		
		final Person transformedPerson = new Person(firstName, lastname);
		
		log.info("Converting (" + person + ") into (" + transformedPerson +")");
		return transformedPerson;
	}

}
