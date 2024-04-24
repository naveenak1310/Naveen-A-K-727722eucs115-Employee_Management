package com.login.login.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.login.login.model.Employee;
import com.login.login.repository.EmployeeRepository;

@Service
public class EmployeeService {
    public EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    public Employee postMethod(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public Employee getEmployee(int id)
    {
        return employeeRepository.findById(id).orElse(null);
    }
    public void deleteEmployee(int id)
    {
        employeeRepository.deleteById(id);
    }
    public Page<Employee> pageEmployee(int size,int pageno)
    {
        PageRequest pageRequest=PageRequest.of(size, pageno);
        return employeeRepository.findAll(pageRequest);
    }
    
}
