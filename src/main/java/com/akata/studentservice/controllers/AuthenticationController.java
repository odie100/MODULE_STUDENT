package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.StudentResponseDTO;
import com.akata.studentservice.model.RegistrationStudentModel;
import com.akata.studentservice.model.SignInModel;
import com.akata.studentservice.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/authentication")
public class AuthenticationController {

    @Autowired
    private StudentService studentService;

    /*@CrossOrigin(origins = "http://localhost:3000")*/
    @PostMapping(path = "/signin/student")
    public StudentResponseDTO signIn(@RequestBody SignInModel signInModel){
        return this.studentService.signIn(signInModel.getEmail(), signInModel.getPassword());
    }

    @PostMapping(path = "/register/student")
    public StudentResponseDTO register(@RequestBody RegistrationStudentModel registrationStudentModel){
        return this.studentService.register(registrationStudentModel);
    }

}
