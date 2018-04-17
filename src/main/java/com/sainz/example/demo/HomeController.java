package com.sainz.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

@Autowired
PersonRepository personRepo;

@RequestMapping("/")
public String showIndex(Model model)
{
model.addAttribute("people", personRepo.findAll());
return "index";
}

@GetMapping("/add")
public String addPerson(Model model)
{
model.addAttribute("aPerson", new Person());
return "addperson";
}


@PostMapping("/saveperson")
public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult result)
{
if(result.hasErrors())
{
return "addperson";
}
//have to make sure we are checking it as well
// this person is the lower case of Person person
personRepo.save(person);
return "redirect:/";

}

@RequestMapping("/update/{id}")
//name of a java method that returns a string (updatePerson) - doesn't matter what you name it
    public String updatePerson(@PathVariable("id") long id, Model model)
{
    //trying to find an individual object by the number used to identify it
    //addAttribute called "aPerson", from what connects it with the database(personRepo) you find something with a given id (in PathVariable)
    //I called my model "aPerson"  and in my addPerson HTML page it is a variable
    model.addAttribute("aPerson", personRepo.findById(id));
    return "addperson";
}

        @RequestMapping("/delete/{id}")
        public String deletePerson ( @PathVariable("id") long id){
             personRepo.deleteById(id);
             return "redirect:/";
        }
}







/*
//Originally put @Entity below - this is not @Entity
@Controller
public class HomeController {

    @Autowired
    PersonRepository addressbook;

    @RequestMapping("/")
    public String index (Model model)
    {
        model.addAttribute("personList", addressbook.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addPerson (Model model) {
        model.addAttribute("aPerson", new Person());
        return "addPerson";
    }


    /*
    @GetMapping("/show")
    public String showPerson (Model model) {
        model.addAttribute("aPerson", new Person());
        return "index";
        }

        */

/*
    @PostMapping("/saveperson")
      public String savePerson(@Valid @ModelAttribute("aPerson") Person person, BindingResult result)
    {
      if(result.hasErrors())
      {
          return "addPerson";
      }
      addressbook.save(person);
      return "redirect:/";

    //}

    //{

    }

}

*/

/*
@PostMapping("/savebook")
public String saveBook(@Valid @ModelAttribute("aBook") Book book, BindingResult result)
        {
        if(result.hasErrors())
        {
        return  "addBook";
        }

        library.save(book);
        return "redirect:/";
        }
        }
        */