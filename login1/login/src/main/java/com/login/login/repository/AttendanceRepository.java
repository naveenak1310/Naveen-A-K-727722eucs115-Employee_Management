package com.login.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.login.model.Attendance;
import java.util.List;


@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer>
{
    List<Attendance> findByPresent(String Present);
    
} 
