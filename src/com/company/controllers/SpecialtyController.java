package com.company.controllers;

import java.util.List;

import com.company.entities.Specialty;
import com.company.repositories.interfaces.ISpecialtyRepository;


public class SpecialtyController {
    private final ISpecialtyRepository repo;

    public SpecialtyController(ISpecialtyRepository repo) {
        this.repo = repo;
    }

    public String createSpecialty(String name) {
        Specialty Specialty = new Specialty(name);

        boolean created = repo.createSpecialty(Specialty);

        return (created ? "Specialty was created!" : "Specialty creation was failed!");
    }

    public String getSpecialty(int id) {
        Specialty Specialty = repo.getSpecialty(id);

        return (Specialty == null ? "Specialty was not found!" : Specialty.toString());
    }

    public String getAllSpecialty() {
        List<Specialty> Specialty = repo.getAllSpecialty();

        return Specialty.toString();
    }
}
