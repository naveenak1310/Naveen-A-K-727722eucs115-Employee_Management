package com.login.login.controller;

import org.springframework.web.bind.annotation.RestController;

import com.login.login.model.Employee;
import com.login.login.services.EmployeeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    public EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PostMapping("/path")
    public Employee postMethodName(@RequestBody Employee employee) {
    
        return employeeService.postMethod(employee);
    }
    @GetMapping("/path/{id}")
    public ResponseEntity<Employee> getMethodName(@PathVariable ("id") int id,@RequestBody Employee employee) {
        return new  ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
    }
    @PutMapping("path/put/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable int id, @RequestBody Employee employee) {
        Employee employee2=employeeService.getEmployee(id);
        if(employee2!=null)
        {
            employee2.setEmployeename(employee.getEmployeename());
            employee2.setEmployeeSalary(employee.getEmployeeSalary());
            employee2.setEmployeeJoin(employee.getEmployeeJoin());
            employee2.setEmployeeExperience(employee.getEmployeeExperience());
            employee2.setEmployeeAge(employee.getEmployeeAge());
            employee2.setEmployeeAddress(employee.getEmployeeAddress());
            return new ResponseEntity<>("updated successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("inavlid id",HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> daleteMethod(@PathVariable("id") int id)
    {
        Employee employee=employeeService.getEmployee(id);
        if(employee!=null)
        {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
            
        }
        else{
            return new ResponseEntity<>("inavlid id",HttpStatus.NOT_ACCEPTABLE);
            
        }


    }
    @GetMapping("/get/{size}/{pageno}")
    public List<Employee> getMethodName(@PathVariable ("size") int size,@PathVariable ("pageno") int pageno) {
        return employeeService.pageEmployee(size, pageno).getContent();
    }
    
    
    

    
}
