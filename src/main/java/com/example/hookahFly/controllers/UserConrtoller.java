package com.example.hookahFly.controllers;


import com.example.hookahFly.role.User;
import com.example.hookahFly.service.SecurityService;
import com.example.hookahFly.service.UserService;
import com.example.hookahFly.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserConrtoller {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "registration";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "registranion";
        }
        userService.save(userForm);

        securityService.autoloogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";


        }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){
        if(error!=null){
            model.addAttribute("error", "Error");
        }
        if(logout!= null){
            model.addAttribute("message","Loged is failed");
        }

        return "login";

    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){
        return "admin";
    }

}
