package com.company.controllers;

import java.util.List;

import com.company.entities.Specialty;
import com.company.entities.Employee;
import com.company.repositories.interfaces.ISpecialtyRepository;// loco
import com.company.repositories.interfaces.IEmployeeRepository; // train


public class EmployeeController {
    private final IEmployeeRepository repo;
    private final ISpecialtyRepository specialtyRepo;
    public EmployeeController(IEmployeeRepository repo,ISpecialtyRepository specialtyRepo) {

        this.repo = repo;
        this.specialtyRepo = specialtyRepo;
    }

    public String createEmployee(String name, String surname, boolean gender , int s_id) {
        Employee employee = new Employee(name,surname, gender, s_id);

        boolean created = repo.createEmployee(employee);

        return (created ? "Employee was created!" : "Employee creation was failed!");
    }

    public String getEmployee(int id) {
        Employee employee = repo.getEmployee(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllEmployee() {
        List<Employee> employees = repo.getAllEmployee();

        return employees.toString();
    }

    public String createSpecialty(String name) {
       Specialty specialty = new Specialty(name);

        boolean created =specialtyRepo.createSpecialty(specialty);

        return (created ? "specialty was created!" : "specialty creation was failed!");
    }

    public Specialty getSpecialty(int id) {
        Specialty specialty = specialtyRepo.getSpecialty(id);
        return specialty;

    }

    public String getAllSpecialty() {
        List<Specialty> specialties = specialtyRepo.getAllSpecialty();

        return specialties.toString();
    }
    public int getSum(int id) {
       int specialty = specialtyRepo.getSum(id);
        return specialty;

    }


}
