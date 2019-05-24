package com.kenzanservice.main.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kenzanservice.main.db.Employee;
import com.kenzanservice.main.db.EmployeeRepository;

/*
 * The main service of the kenzan app
 */
@Controller
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@RequestMapping(method = RequestMethod.GET, value = "/employees/allemployees")
	@ResponseBody
	@RolesAllowed("ADMIN")
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
	@ResponseBody
	@RolesAllowed("ADMIN")
	public Employee getEmployeedById(@PathVariable long id) {
		return repository.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees/createemployee")
	@ResponseBody
	@RolesAllowed("ADMIN")
	public Employee saveEmployee(@RequestBody Employee e) {

		return repository.save(e);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/updateemployee/{id}")
	@ResponseBody
	@RolesAllowed("ADMIN")
	public Employee updateEmployee(@RequestBody Employee e, @PathVariable long id) {
		e.setId(id);
		return repository.save(e);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/delete/{id}")
	@ResponseBody
	@RolesAllowed("ADMIN")
	public Employee deleteEmployee(@RequestBody Employee e, @PathVariable long id) {

		e.setId(id);
		e.setStatus("Inactive");
		return repository.save(e);

	}

}
