package com.company;

import com.company.controllers.SpecialtyController;
import com.company.controllers.EmployeeController;
import com.company.entities.Specialty;
import com.company.repositories.interfaces.ISpecialtyRepository;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.Scanner;

public class SpecialtyApp {
    private final EmployeeController controller;
    private final Scanner scanner;

    public SpecialtyApp(IEmployeeRepository EmployeeRepository, ISpecialtyRepository SpecialtyRepository) {
        controller = new EmployeeController(EmployeeRepository, SpecialtyRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all Specialty");
            System.out.println("2. Get Specialty by id");
            System.out.println("3. Create Specialty");
            System.out.println("4. Get Sum of your project");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllSpecialtyMenu();
                } else if (option == 2) {
                    getSpecialtyByIdMenu();
                } else if (option == 3) {
                    createSpecialtyMenu();
                } else if (option == 4) {
                    getSum();
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

    public void getAllSpecialtyMenu() {
        String response = controller.getAllSpecialty();
        System.out.println(response);
    }

    public void getSpecialtyByIdMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        Specialty Specialty = controller.getSpecialty(id);
        System.out.println((Specialty == null ? "Specialty was not found!" : Specialty.toString()));
    }

    public void createSpecialtyMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();

        String response = controller.createSpecialty(name);
        System.out.println(response);
    }

    public void getSum() {
        while (true) {
            System.out.println("1.Add 2.Show all speciality 3.Show sum 4.exit");
            int selected = scanner.nextInt();
            int projectSum = 0;
            if (selected == 1) {
                System.out.println("Please enter id");
                int id = scanner.nextInt();
                projectSum += controller.getSum(id);
            } else if (selected == 2) {
                getAllSpecialtyMenu();
            } else if (selected == 3) {
                System.out.println(projectSum);
            } else if (selected == 4)
                break;

        }
    }
}
//        System.out.println((Specialty == 0 ? "Specialty was not found!" : Specialty));





//        var specialities = controller.getAllSpecialty();
//        specialities.stream().mapToDouble(n->n.salary).sum();
