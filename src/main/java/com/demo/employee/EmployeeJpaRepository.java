package com.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeDto,Integer> {
    //Creation of custom queries by method name using keyWords

    List<EmployeeDto> findByName(String name);
    List<EmployeeDto> findByNameContaining(String name);
    List<EmployeeDto> findBySalaryBetweenOrderByNameDesc(Double minSalary,Double maxSalary);
    List<EmployeeDto> findBySalaryBetweenOrderByNameAsc(Double minSalary,Double maxSalary);
    List<EmployeeDto> findBySalaryBetweenOrderBySalaryDesc(Double minSalary,Double maxSalary);
    // By writing JPQL Queries
    @Query("SELECT employee FROM EmployeeDto employee")
    List<EmployeeDto> getAllEmployees();

    @Query("SELECT employee FROM EmployeeDto employee WHERE employee.name LIKE :name")
    List<EmployeeDto> getAllEmployeesHavingNameLike(String name);


}
