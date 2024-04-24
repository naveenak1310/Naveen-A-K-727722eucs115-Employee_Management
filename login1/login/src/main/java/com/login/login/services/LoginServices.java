package com.login.login.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.login.login.model.Login;
import com.login.login.repository.LoginRepository;

@Service
public class LoginServices {
    public LoginRepository loginRepository;
    public LoginServices(LoginRepository loginRepository)
    {
        this.loginRepository=loginRepository;
    }
    public Login postLogin(Login login)
    {
        return loginRepository.save(login);
    }
    public Login GetLogin(int id)
    {
        return loginRepository.findById(id).orElse(null);
    }
    
}
