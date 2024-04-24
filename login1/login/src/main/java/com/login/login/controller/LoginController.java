package com.login.login.controller;

import org.springframework.web.bind.annotation.RestController;

import com.login.login.model.Login;
import com.login.login.services.LoginServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/Login")

public class LoginController {
    public LoginServices loginServices;
    public LoginController(LoginServices loginServices)
    {
        this.loginServices=loginServices;
    }
    @PostMapping("/path")
    public Login postMethodName(@RequestBody Login login) {
        return loginServices.postLogin(login);
    }
    @GetMapping("/path/{id}")
    public ResponseEntity<Integer> getMethodName(@PathVariable ("id") int id,@RequestBody Login login) {
        Login login1=loginServices.GetLogin(id);
        if(login1!=null)
        {
            return new ResponseEntity<> (123,HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<> (404,HttpStatus.NOT_FOUND);
        }
    }
} 
    
    
       
