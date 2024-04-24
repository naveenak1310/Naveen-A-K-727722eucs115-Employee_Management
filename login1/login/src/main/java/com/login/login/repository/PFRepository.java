package com.login.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.login.login.model.PF;


@Repository
public interface PFRepository extends JpaRepository<PF,Integer> {

    
} 
