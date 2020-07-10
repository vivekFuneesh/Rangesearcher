package com.vivek.rangesearcher.model.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vivek.rangesearcher.model.data.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

}
