package com.github.prekel.JavaSpring.Lab06.controller;

import com.github.prekel.JavaSpring.Lab06.component.UsersRepository;
import com.github.prekel.JavaSpring.Lab06.entity.Users;
import com.github.prekel.JavaSpring.Lab06.form.UserForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    public final BCryptPasswordEncoder passwordEncoder;
    private final UsersRepository repository;

    public RegistrationController(@Qualifier("usersRepository") UsersRepository repository, @Qualifier("passwordEncoder") BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showAddShoesForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "registration";
    }

    @PostMapping
    public String saveUserToDb(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
        try {
            Users newUser = new Users(userForm.getUsername(), passwordEncoder.encode(userForm.getPassword()));
            repository.save(newUser);
            System.out.println("New user created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}
