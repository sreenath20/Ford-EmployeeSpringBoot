package com.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public EmployeeDto registerEmployee(EmployeeDto newEmployee) {


        return this.employeeJpaRepository.save(newEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer employeeId) throws EmployeeException {
        Optional<EmployeeDto> employeeOptional = this.employeeJpaRepository.findById(employeeId);
        if(employeeOptional.isEmpty())
            throw new EmployeeException("Employee could not be found id:"+employeeId);

        return employeeOptional.get();
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employee) throws EmployeeException{
        Optional<EmployeeDto> employeeOptional = this.employeeJpaRepository.findById(employee.getId());
        if(employeeOptional.isEmpty())
            throw new EmployeeException("Employee could not be updated, not found id:"+employee.getId());
        return this.employeeJpaRepository.save(employee);
    }

    @Override
    public EmployeeDto deleteEmployeeById(Integer employeeId) throws EmployeeException {
        Optional<EmployeeDto> employeeOptional = this.employeeJpaRepository.findById(employeeId);
        if(employeeOptional.isEmpty())
            throw new EmployeeException("Employee could not be Deleted, not found id:"+employeeId);
        EmployeeDto foundEmployee = employeeOptional.get();
        this.employeeJpaRepository.delete(foundEmployee);
        return foundEmployee;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return this.employeeJpaRepository.findAll();
    }
}
