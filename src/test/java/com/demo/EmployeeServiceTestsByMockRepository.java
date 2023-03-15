package com.demo;

import com.demo.employee.EmployeeDto;
import com.demo.employee.EmployeeException;
import com.demo.employee.CollectionEmployeeRepository;
import com.demo.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class EmployeeServiceTestsByMockRepository {

    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private CollectionEmployeeRepository employeeRepository;
    @Test
    public void testServiceWithOutActualRepository() throws EmployeeException{
        given(this.employeeRepository.getEmployee(100))
                .willReturn(new EmployeeDto(100,"Ford", 2500.0));
        assertEquals("Ford",employeeService.getEmployeeById(100).getName());
    }

    @Test
    public void testGetEmployeeThrowsExceptionTest() throws EmployeeException{

        given(this.employeeRepository.getEmployee(200))
                .willReturn(null);
        assertThrows(EmployeeException.class,()->employeeService.getEmployeeById(200));
    }
}
