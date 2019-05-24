package com.kenzanservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kenzanservice.main.db.Employee;
import com.kenzanservice.main.db.EmployeeRepository;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/*
 * The start of point of the Kenzan App
 */
@SpringBootApplication
public class StarterKenzanApp implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StarterKenzanApp.class, args);
	}

	public void run(String... args) {

		System.out.println("Start Kenzan Application...");

		System.out.println("Adding some records......");

		repository.save(new Employee("Luis", "Perez", "Couto", new Date(), new Date(), "Active"));
		repository.save(new Employee("Tadeo", "Perez", "Couto", new Date(), new Date(), "Inactive"));

	}

}
