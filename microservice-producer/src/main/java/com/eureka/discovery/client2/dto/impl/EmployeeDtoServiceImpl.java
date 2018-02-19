package com.eureka.discovery.client2.dto.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.eureka.discovery.client2.bo.Employee;
import com.eureka.discovery.client2.dto.EmployeeDtoService;

/**
 * 
 * @author gaugupta
 *
 */
@Repository
public class EmployeeDtoServiceImpl implements EmployeeDtoService {
	
	private Map<Integer, Employee> EmployeeMap = new HashMap<>();
	
	public EmployeeDtoServiceImpl() {
		Employee employee1 = new Employee(1, "gaurav", 1000);
		Employee employee2 = new Employee(2, "utkarsh", 8000);
		Employee employee3 = new Employee(3, "gorav", 1500);
		Employee employee4 = new Employee(4, "asutosh", 1000);
		EmployeeMap.put(employee1.getId(), employee1);
		EmployeeMap.put(employee2.getId(), employee2);
		EmployeeMap.put(employee3.getId(), employee3);
		EmployeeMap.put(employee4.getId(), employee4);

	}
	
	@Override
	public List<Employee> getEmployeeList() {
		return new ArrayList<Employee>(EmployeeMap.values());
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return EmployeeMap.get(id);
	}

}
