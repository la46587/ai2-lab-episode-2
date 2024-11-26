package com.example.temat1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String listPeople(Model model) {
        model.addAttribute("people", personService.getPeople());
        return "persons";
    }

    @GetMapping("/persons/{index}")
    public String getPerson(@PathVariable int index, Model model) {
        try {
            Person person = personService.getPerson(index);
            model.addAttribute("person", person);
            return "person";
        } catch (IndexOutOfBoundsException e) {
            model.addAttribute("error", "Person not found");
            return "error";
        }
    }

    @GetMapping("/persons/add")
    public String showAddPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @PostMapping("/persons/add")
    public String addPerson(Person person) {
        personService.addPerson(person);
        return "redirect:/persons";
    }
}
