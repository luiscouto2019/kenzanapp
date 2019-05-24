package com.kenzanservice.main.controller;

import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.kenzanservice.main.db.Employee;
import com.kenzanservice.main.services.ClientWSEmployee;
import com.kenzanservice.main.vo.SearchVo;

/*
 * Defining the controller for the Kenzan App
 */
@Controller
public class EmployeeController {

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	ClientWSEmployee clientWsEmployee = new ClientWSEmployee();

	@RequestMapping(value = "/moduleEmployees/saveEmployee", method = RequestMethod.POST)
	public ModelAndView newEmployee(ModelAndView model, @ModelAttribute Employee e) {

		String msg = null;
		boolean flagOp = false;

		flagOp = clientWsEmployee.createEmployee(e);

		if (flagOp)
			msg = "The record was created successfully";
		else
			msg = "Error: There was a problem on the operation";

		model.addObject("msg", msg);

		model.setViewName("confirmation");
		return model;
	}

	@RequestMapping(value = "/moduleEmployees/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(ModelAndView model, @ModelAttribute Employee e) {

		String msg = null;
		boolean flagOp = false;

		flagOp = clientWsEmployee.updateEmployee(e);

		if (flagOp)
			msg = "The operation was made successfully";
		else
			msg = "Error: There was a problem on the operation";

		model.addObject("msg", msg);
		model.setViewName("confirmation");
		return model;
	}

	@RequestMapping(value = "/moduleEmployees/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(ModelAndView model, @RequestParam("idemployee") String idemployee) {

		Employee employee = clientWsEmployee.getEmployee(idemployee);
		model.addObject("employee", employee);
		model.setViewName("editEmployee");
		return model;
	}

	@RequestMapping(value = "/moduleEmployees/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		model.addObject("employee", new Employee());
		model.setViewName("newEmployee");
		return model;
	}

	@RequestMapping(value = "/moduleEmployees/searchEmployee", method = RequestMethod.GET)
	public ModelAndView begin(ModelAndView model) {

		System.out.println("searchEmployee....");

		Employee[] lstEmployees = clientWsEmployee.getListEmployees();
		model.addObject("lstEmployees", lstEmployees);
		model.addObject("searchForm", new SearchVo());
		model.setViewName("search");
		return model;

	}
	
}
