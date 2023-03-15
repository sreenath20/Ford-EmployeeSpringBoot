package com.demo.employee;

public interface CollectionEmployeeRepository {
    EmployeeDto addEmployee(EmployeeDto employee);
    EmployeeDto getEmployee(Integer id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    EmployeeDto deleteEmployee(Integer employeeId);
}
