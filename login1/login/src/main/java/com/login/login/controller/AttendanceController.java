package com.login.login.controller;

import org.springframework.web.bind.annotation.RestController;

import com.login.login.model.Attendance;
import com.login.login.services.AttendanceServices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@RequestMapping("/Attendance")
public class AttendanceController {
    public AttendanceServices attendanceServices;
    public AttendanceController(AttendanceServices attendanceServices)
    {
        this.attendanceServices=attendanceServices;
    }
    @PostMapping("/post")  
    public Attendance postMethod(@RequestBody Attendance attendance)
    {
        return attendanceServices.postAttendance(attendance);
    }
    @GetMapping("/path")
    public List<Attendance>getMethodName() {
        return attendanceServices.getAll();
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getMethodName(@PathVariable ("id") int id) {
        Attendance attendance1=attendanceServices.getAttendance(id);
        if(attendance1!=null)
        {
            attendanceServices.getAttendance(id);
            return new  ResponseEntity<>("dispalyed successfully",HttpStatus.ACCEPTED);
        }
        
            return new ResponseEntity<>("invalid id",HttpStatus.NOT_FOUND);

        // return ResponseEntity<>("displaye sucessfully",HttpStatus.OK);
    }
    @GetMapping("/path/pre")
    public List<Attendance> getMethodName(@RequestParam String Present) {
        return attendanceServices.getPresentAttendances(Present);
    }
    

    
}
