package com.kenzanservice.main.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Creating the Employee Repository for the Kenzan App
 * @author LUIS
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findById(Long id);
    @Query("select e from Employee e where e.status='Active'")
    List<Employee> findAll();
    
}