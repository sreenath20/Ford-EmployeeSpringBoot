package com.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
//@Service
public class CollectionEmployeeServiceImpl implements EmployeeService{

    @Autowired
    private CollectionEmployeeRepository employeeRepository;

    @Override
    public EmployeeDto registerEmployee(EmployeeDto newEmployee) {
        return employeeRepository.addEmployee(newEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer employeeId)throws EmployeeException {
        EmployeeDto foundEmployee = employeeRepository.getEmployee(employeeId);
        if(foundEmployee == null)
            throw new EmployeeException("Employee Id does not exists.");

        return foundEmployee;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public EmployeeDto deleteEmployeeById(Integer employeeId)throws EmployeeException {
      EmployeeDto foundEmployee = employeeRepository.getEmployee(employeeId);
      if(foundEmployee==null)
          throw new EmployeeException("Employee coud't be deleted, Id not found:"+employeeId);
        return employeeRepository.deleteEmployee(employeeId);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return null;
    }
}
