/**
 * 
 */
package com.eureka.discovery.client2.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.discovery.client2.bo.Employee;
import com.eureka.discovery.client2.dto.EmployeeDtoService;

/**
 * 
 * @author gaugupta
 *
 */
@RestController
public class EmployeeServerController {

	
	@Autowired
	EmployeeDtoService service;
	
	@RequestMapping(value = "/employees", method= RequestMethod.GET)
	public Employee[] all(HttpServletRequest request) {
		System.out.println("Local PORT ----------------"+request.getLocalPort()+"-------------------");
		List<Employee> employeeList = service.getEmployeeList();
		return employeeList.toArray(new Employee[employeeList.size()]);
	}
	
	@RequestMapping(value = "/employees/{id}", method= RequestMethod.GET)
	public Employee byId(@PathVariable("id") Integer id,HttpServletRequest request) {
		System.out.println("Local PORT ----------------"+request.getLocalPort()+"-------------------");
		Employee employee = service.getEmployeeById(id);
		return employee;
	}
}
