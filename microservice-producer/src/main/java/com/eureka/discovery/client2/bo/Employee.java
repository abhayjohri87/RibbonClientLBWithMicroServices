package com.eureka.discovery.client2.bo;

import java.io.Serializable;

/**
 * 
 * @author gaugupta
 *
 */
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Employee(Integer id, String name, long salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Integer id;
	public String name;
	public long salary;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee id= :"+id+",  name=:"+name+", salary=:"+salary;
	}
	
}

