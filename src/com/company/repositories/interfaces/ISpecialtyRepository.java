package com.company.repositories.interfaces;

import com.company.entities.Specialty;
import com.company.entities.Employee;

import java.util.List;

public interface ISpecialtyRepository {
        boolean createSpecialty(Specialty specialty);
        Specialty getSpecialty(int id);
        List<Specialty> getAllSpecialty();
     //   int getSum2(int id);

        int getSum(int id);
}


