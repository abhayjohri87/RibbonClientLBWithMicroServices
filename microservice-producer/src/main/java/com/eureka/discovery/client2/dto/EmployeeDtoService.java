/**
 * 
 */
package com.eureka.discovery.client2.dto;

import java.util.List;

import com.eureka.discovery.client2.bo.Employee;

/**
 * 
 * @author gaugupta
 *
 */
public interface EmployeeDtoService {
	
	List<Employee> getEmployeeList();
	
	Employee getEmployeeById(Integer id);
}
