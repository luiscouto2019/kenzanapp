package com.kenzanservice.main.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kenzanservice.main.db.Employee;

/*
 * Creating the client for the WS Employee on Kenzan App
 */
public class ClientWSEmployee {

	static String url_getallEmployees = "http://localhost:8080/employees/allemployees";
	static String url_getEmployee = "http://localhost:8080/employees/{id}";
	static String url_createEmployee = "http://localhost:8080/employees/createemployee";
	static String url_updateEmployee = "http://localhost:8080/employees/updateemployee/{id}";
	static String url_deleteEmployee = "http://localhost:8080/employees/delete/{id}";
	static String plainCreds = "luis:password";

	RestTemplate restTemplate = null;
	HttpHeaders headers = null;
	HttpEntity<Employee> request = null;
	Map<String, String> param = null;
	Employee[] lstEmployees = null;
	Employee employee = null;
	String base64Creds = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	ResponseEntity<Employee> responseEmployee = null;
	ResponseEntity<Employee[]> responseListEmp = null;
	boolean returnFlag = false;

	private String getBase64Creds() {
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		return base64Creds;
	}

	public Employee[] getListEmployees() {

		base64Creds = getBase64Creds();
		headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		restTemplate = new RestTemplate();

		request = new HttpEntity<>(headers);
		responseListEmp = restTemplate.exchange(url_getallEmployees, HttpMethod.GET, request, Employee[].class);
		lstEmployees = responseListEmp.getBody();

		return lstEmployees;
	}

	public Employee getEmployee(String idemployee) {

		base64Creds = getBase64Creds();
		headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		restTemplate = new RestTemplate();

		param = new HashMap<String, String>();
		param.put("id", idemployee);
		request = new HttpEntity<>(headers);

		responseEmployee = restTemplate.exchange(url_getEmployee, HttpMethod.GET, request, Employee.class, param);

		employee = responseEmployee.getBody();

		return employee;
	}

	public boolean createEmployee(Employee e) {

		try

		{

			e.setDateOfBirth(dateFormat.parse(e.getStringDateBirth()));
			e.setDateOfEmployment(dateFormat.parse(e.getStringDateOfEmployment()));
			e.setStatus("Active");
			base64Creds = getBase64Creds();
			headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);

			restTemplate = new RestTemplate();
			returnFlag = false;

			request = new HttpEntity<>(e, headers);
			responseEmployee = restTemplate.postForEntity(url_createEmployee, request, Employee.class);

			if (responseEmployee.getStatusCodeValue() == 200)
				returnFlag = true;

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return returnFlag;

	}

	public boolean updateEmployee(Employee e) {

		try

		{

			base64Creds = getBase64Creds();
			headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			restTemplate = new RestTemplate();
			returnFlag = false;

			e.setDateOfBirth(dateFormat.parse(e.getStringDateBirth()));
			e.setDateOfEmployment(dateFormat.parse(e.getStringDateOfEmployment()));
			e.setStatus("Active");

			param = new HashMap<String, String>();
			param.put("id", e.getId().toString());
			request = new HttpEntity<>(e, headers);

			if (e.getDeleteOp().equals("1"))
				responseEmployee = restTemplate.exchange(url_deleteEmployee, HttpMethod.PUT, request, Employee.class,
						param);
			else
				responseEmployee = restTemplate.exchange(url_updateEmployee, HttpMethod.PUT, request, Employee.class,
						param);

			if (responseEmployee.getStatusCodeValue() == 200)
				returnFlag = true;

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return returnFlag;
	}

}
