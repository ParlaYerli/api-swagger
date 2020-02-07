package com.example.demo.Service;

import com.example.demo.Model.Person;
import com.example.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonDao {
    @Autowired
    PersonRepository personRepository;
    public Person save(Person person){
        return personRepository.save(person);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findOne(Integer id){
        return personRepository.getOne(id);
    }

    public void delete(Person person){
        personRepository.delete(person);
    }
}
