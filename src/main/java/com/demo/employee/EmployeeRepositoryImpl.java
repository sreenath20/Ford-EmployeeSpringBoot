package com.demo.employee;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Component
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    Map<Integer,EmployeeDto> employeeDtoMap = new HashMap<>();

    @Override
    public EmployeeDto addEmployee(EmployeeDto employee) {
        employeeDtoMap.put(employee.getId(),employee);
        return employee;
    }

    @Override
    public EmployeeDto getEmployee(Integer id) {
        return employeeDtoMap.get(id);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        return employeeDtoMap.replace(employeeDto.getId(),employeeDto);
    }

    @Override
    public EmployeeDto deleteEmployee(Integer employeeId) {
        return employeeDtoMap.remove(employeeId);
    }
}
