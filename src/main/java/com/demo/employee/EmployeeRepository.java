package com.demo.employee;

public interface EmployeeRepository {
    EmployeeDto addEmployee(EmployeeDto employee);
    EmployeeDto getEmployee(Integer id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    EmployeeDto deleteEmployee(Integer employeeId);
}
