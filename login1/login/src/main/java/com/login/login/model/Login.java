package com.login.login.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Login {
    @Id
    // @GeneratedValue(strategy =GenerationType.IDENTITY)
    public int Employeeid;
    public String useString;
    public String pasString;
    public String phoneString;
    public String Address;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Employee employee;
    
}