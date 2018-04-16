package com.sainz.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


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