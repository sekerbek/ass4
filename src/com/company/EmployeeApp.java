package com.company;

import com.company.controllers.EmployeeController;
import com.company.repositories.interfaces.ISpecialtyRepository;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.Scanner;


public class EmployeeApp {
    private final EmployeeController controller;
    private final Scanner scanner;
    public EmployeeApp(IEmployeeRepository EmployeeRepository, ISpecialtyRepository SpecialtyRepository) {
        controller = new EmployeeController(EmployeeRepository, SpecialtyRepository );
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all Employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Create employee");


            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeeMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                } else if (option == 4) {
                    getTotalCostOfProjectsByMajor();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    public void getAllEmployeeMenu() {
        String response = controller.getAllEmployee();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female) 1-m, 0-f");
        boolean gender = scanner.nextBoolean();

        int s_id = scanner.nextInt();

        String response = controller.createEmployee(name, surname, gender, s_id);
        System.out.println(response);
    }

    public void getTotalCostOfProjectsByMajor() {
        System.out.println("Please enter major which you need");
     //   String major = scanner.next();

        int id = scanner.nextInt();
        String response = controller.getEmployee(id); // major
        System.out.println(response);
    }
}
