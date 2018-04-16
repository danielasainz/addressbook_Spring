package com.sainz.example.demo;

//import com.sainz.example.demospring.model.Person;
//import me.afua.demospring.model.Book;  WHERE DID FI GET THIS?!?

import org.springframework.data.repository.CrudRepository;

//Says "PersonRepository" is never used... What's the problem?
public interface PersonRepository extends CrudRepository<Person, Long> {

    //Iterable<Person> findAllByFirstNameIgnoringCase()
}
