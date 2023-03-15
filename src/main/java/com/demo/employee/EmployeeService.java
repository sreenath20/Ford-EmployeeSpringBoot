package com.demo.employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto registerEmployee(EmployeeDto newEmployee);
    EmployeeDto getEmployeeById(Integer employeeId)throws EmployeeException;
    EmployeeDto updateEmployee(EmployeeDto employee)throws EmployeeException;
    EmployeeDto deleteEmployeeById(Integer employeeId) throws EmployeeException;
    List<EmployeeDto> getAllEmployees();
}
