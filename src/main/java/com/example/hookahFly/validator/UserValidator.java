package com.example.hookahFly.validator;


import com.example.hookahFly.role.User;
import com.example.hookahFly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;



    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
            User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if(user.getUsername().length() < 8 || user.getUsername().length() > 32){
            errors.rejectValue("username", "Size more");
        }
        if(userService.findByUsername(user.getUsername()) != null){
            errors.rejectValue("username","uje est");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if(user.getPassword().length() < 8 || user.getPassword().length() > 32){
            errors.rejectValue("password", "Error");
        }
        if (user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("password", "Error");
        }




    }
}
