package com.login.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.login.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer>{

    
} 
