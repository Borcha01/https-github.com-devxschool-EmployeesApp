package com.devxschool.demo.repositories;

import com.devxschool.demo.domain.Employee;

public interface CustomizedEmployeeRepo {
    Employee incrementSalary(Long id, Float incrValue);
    Employee decrementSalary(Long id, Float decrValue);
    Float getTax(Long id, Float percentage);
}
