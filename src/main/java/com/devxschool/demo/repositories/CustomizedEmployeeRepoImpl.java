package com.devxschool.demo.repositories;

import com.devxschool.demo.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class CustomizedEmployeeRepoImpl implements CustomizedEmployeeRepo {

    @Autowired
    private EntityManager em;

    @Override
    public Employee incrementSalary(Long employeeId, Float incrFloat) {
        Employee emp = em.find(Employee.class, employeeId);
        emp.setSalary(emp.getSalary() + incrFloat);
        em.persist(emp);
        return emp;
    }

    @Override
    public Employee decrementSalary(Long employeeId, Float decrFloat) {
        Employee emp = em.find(Employee.class, employeeId);
        emp.setSalary(emp.getSalary() - decrFloat);
        em.persist(emp);
        return emp;
    }

    @Override
    public Float getTax(Long employeeId, Float percentege) {
        Employee emp = em.find(Employee.class, employeeId);
        return emp.getSalary() * percentege / 100;
    }


}
