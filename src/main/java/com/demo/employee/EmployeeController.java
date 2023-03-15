package com.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//localhost:8090/swagger-ui.html

@RestController
@RequestMapping(value = "/v1") //
@CrossOrigin(value = "http://localhost:4200/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService ;

    @RequestMapping(method = RequestMethod.GET, value = "/")
   // @GetMapping("/")
    public String greet(){
        return "Welcome to my demo spring boot application !";
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Integer id) throws EmployeeException{

        //return "get employee by id"+id;
        return employeeService.getEmployeeById(id);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/employee")
    @PostMapping("/employee") // bind incoming JSON data and parameter
    @ResponseStatus(value = HttpStatus.CREATED)
    public EmployeeDto addResource(@Valid @RequestBody EmployeeDto employee){
       // System.out.println(employee);
        //return employee;
        return employeeService.registerEmployee(employee);
    }

    @PutMapping("/employee") // update employee
    public EmployeeDto replaceResource(@RequestBody EmployeeDto employee) throws EmployeeException {
      //  return "Put request !"+employee;
    return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{employeeId}")// URl template
    public EmployeeDto deleteResource(@PathVariable("employeeId") Integer employeeId ) throws EmployeeException {
        //return "Delete !"+employeeId;
        return employeeService.deleteEmployeeById(employeeId);
    }
    //localhost:8090/employee/1/name/India
    @PatchMapping("/employee/{id}/name/{employeeName}")// partial update od resource
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String updateResourceName(@PathVariable("id") Integer employeeId,@PathVariable("employeeName") String employeeName){
        return "Patch !"+employeeId+":"+employeeName;
    }

    @GetMapping("employees")
    public List<EmployeeDto> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    @GetMapping("employees/name/{name}")
    public List<EmployeeDto> getAllEmployeesHavingName(@PathVariable("name") String name){
        return this.employeeJpaRepository.findByName(name);
    }
    @GetMapping("employees/contain/{name}")
    public List<EmployeeDto> getAllEmployeesContainingName(@PathVariable("name") String name){
        return this.employeeJpaRepository.findByNameContaining(name);
    }

    @GetMapping("employees/salary/{minSalary}/{maxSalary}")
    public List<EmployeeDto> findAllEmployeesHavingSalaryBetween(@PathVariable("minSalary") Double minSalary,
                                                                 @PathVariable("maxSalary")Double maxSalary){
        return this.employeeJpaRepository.findBySalaryBetweenOrderBySalaryDesc(minSalary,maxSalary);

    }

    @GetMapping("custom/employees")
    public List<EmployeeDto> findAllEmployees(){
        return this.employeeJpaRepository.getAllEmployees();
    }

    @GetMapping("custom/employees/{name}")
    public List<EmployeeDto> findAllEmployeesHavingName(@PathVariable("name") String name){
        return this.employeeJpaRepository.getAllEmployeesHavingNameLike("%"+name+"%");
    }

}
