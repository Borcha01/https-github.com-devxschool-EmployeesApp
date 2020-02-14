package com.devxschool.demo.repositories;

import com.devxschool.demo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, CustomizedEmployeeRepo {
//    Employee incrementSalary(@Param("employee_id") Long empId, @Param("increment") Float incrFloat);
}
