package com.example.demo.Controller;
import com.example.demo.Service.PersonDao;
import com.example.demo.Model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Person Management System")
public class PersonController {
    @Autowired
    PersonDao personDao;

    @PostMapping("/add")
    public Person createPerson(@Valid @RequestBody Person person){
        return personDao.save(person);
    }

    @GetMapping("/allperson")
    public List<Person> getAllPerson(){
        return personDao.findAll();
    }

    @ApiOperation(value = "Get an employee by Id")
    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable(value = "id") int id) {
         return personDao.findOne(id);
    }

    @PutMapping("/person/{id}")
    public String update(@PathVariable(value = "id") int id, @Valid @RequestBody Person person){
        Person person1 = personDao.findOne(id);
        person1.setName(person.getName());
        Person newPerson= personDao.save(person1);
        return "başarıyla değiştirildi";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody @Valid @PathVariable(value = "id") int id){
        Person person=personDao.findOne(id);
        personDao.delete(person);
        return "başarıyla silindi";
    }
}
