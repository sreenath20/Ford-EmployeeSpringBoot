package com.demo;

import com.demo.employee.EmployeeDto;
import com.demo.employee.EmployeeException;
import com.demo.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceIntegrationTests {
//
//	EmployeeDto registerEmployee(EmployeeDto newEmployee);
//	EmployeeDto getEmployeeById(Integer employeeId)throws EmployeeException;
//	EmployeeDto updateEmployee(EmployeeDto employee);
//	EmployeeDto deleteEmployeeById(Integer employeeId) throws EmployeeException;
	@Autowired
	private EmployeeService employeeService;
	@Test
	void registerEmployeeTest() {
		EmployeeDto emp = new EmployeeDto(1,"Ford",25000.0);
		assertEquals("Ford",this.employeeService.registerEmployee(emp).getName());
	}
	@Test
	void getEmployeeByIdThrowsExceptionTest() {
		//EmployeeDto emp = new EmployeeDto(1,"Ford",25000.0);
		assertThrows(EmployeeException.class,()->this.employeeService.getEmployeeById(1000));
	}


}
