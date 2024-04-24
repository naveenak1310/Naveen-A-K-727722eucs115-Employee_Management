package com.login.login.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PF {
    @Id
    public int PFId;
    public int Experience;
    public int PFAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Attendance attendance;
}
