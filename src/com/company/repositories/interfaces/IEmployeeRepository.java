package com.company.repositories.interfaces;

import com.company.entities.Employee;

import java.util.List;
public interface IEmployeeRepository {
 boolean createEmployee(Employee employee);
         Employee getEmployee(int id);
         List<Employee> getAllEmployee();

    }

/** public interface IEmployeeRepository {
    boolean createEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployee();
    int getTotalCostOfProjectsByMajor(int id);**/

