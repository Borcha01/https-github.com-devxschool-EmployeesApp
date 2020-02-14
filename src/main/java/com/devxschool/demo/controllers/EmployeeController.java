package com.devxschool.demo.controllers;

import com.devxschool.demo.domain.Employee;
import com.devxschool.demo.domain.Company;
import com.devxschool.demo.repositories.CompanyRepository;
import com.devxschool.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public  Employee getEmployee(@PathVariable(value="id") Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.get();
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Optional<Company> company = companyRepository.findByName(employee.getCompany().getName());
        if (!company.isPresent())
            companyRepository.save(employee.getCompany());
        else
            employee.setCompany(company.get());

        Employee savedEmployee = employeeRepository.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity < Void > (HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable(value="id") Long id){
        Employee updatedEmployee = employeeRepository.findById(id)
                .map(emp -> {
                    emp.setSalary(employee.getSalary());
                    return employeeRepository.save(emp);
                }).orElseGet(() -> {
                    employee.setId(id);
                    return employeeRepository.save(employee);
                });

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(updatedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/employees/{id}/incrementsalary/{incrementValue}")
    public ResponseEntity<Employee> incrementSalary(@PathVariable(value = "id") Long employeeId,
            @PathVariable(value = "incrementValue") Long incrementValue) {
        Employee emp = employeeRepository.incrementSalary(employeeId, Float.parseFloat(incrementValue.toString()));
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }
     
    @PostMapping("/employees/{id}/decrementsalary/{decrementValue}")
    public ResponseEntity<Employee> decrementSalary(@PathVariable(value = "id") Long employeeId,
            @PathVariable(value = "decrementValue") Long decrementValue) {
        Employee emp = employeeRepository.decrementSalary(employeeId, Float.parseFloat(decrementValue.toString()));
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }
}
