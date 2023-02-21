package com.demo.employee;

public interface EmployeeService {
    EmployeeDto registerEmployee(EmployeeDto newEmployee);
    EmployeeDto getEmployeeById(Integer employeeId)throws EmployeeException;
    EmployeeDto updateEmployee(EmployeeDto employee);
    EmployeeDto deleteEmployeeById(Integer employeeId) throws EmployeeException;
}
