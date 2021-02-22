package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Specialty;
import com.company.entities.Employee;
import com.company.repositories.interfaces.ISpecialtyRepository;

import java.lang.constant.Constable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyRepository implements ISpecialtyRepository {
    private final IDB db;

    public SpecialtyRepository(IDB db) {
        this.db = db;
    }

    /**
     * Here i created method, which create the specialty in database,
     * in order to do user have to input specialty name and salary
     */
    @Override
    public boolean createSpecialty(Specialty Specialty) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO specialty(s_name, s_salary) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, Specialty.getName());
            st.setInt(1, Specialty.getS_salary());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    /**
     * here method which get specialty from db by id(parameter)
     * and output the name and id of specialty
     */
    @Override
    public Specialty getSpecialty(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT s_id,s_name FROM specialty WHERE s_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Specialty Specialty = new Specialty(rs.getInt("s_id"),
                        rs.getString("s_name"));


                return Specialty;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    /**
     * here method which get all specialty from db with no parameter,
     * it output the name and id of all specialties
     */
    @Override
    public List<Specialty> getAllSpecialty() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT s_id,s_name FROM specialty";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Specialty> Specialties = new ArrayList<>();
            while (rs.next()) {
                Specialty specialty = new Specialty(rs.getInt("s_id"),
                        rs.getString("s_name"));


                Specialties.add(specialty);
            }

            return Specialties;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    /**
     * here the main method which get TOTAL SUM OF PROJECT from db by id(parameter),
     * by the id of specialties it count their total salaries= total cost of project;
     */
    @Override
    public int getSum(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT s_id, s_name, s_salary  FROM specialty WHERE s_id == id";


            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            Integer sum = 0;
            if (rs.next()) {
                Specialty specialty = new Specialty(rs.getInt("s_id"),
                        rs.getString("s_name"),
                        rs.getInt("s_salary"));
                sum += specialty.getS_salary();

            }
            return sum;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
//    @Override
//    public int getSum(int id) {
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            String sql = "SELECT s_id, s_name, s_salary  FROM specialty";
//
//
//            PreparedStatement st = con.prepareStatement(sql);
//
//            ResultSet rs = st.executeQuery();
//            Integer sum = 0;
//            while (rs.next()) {
//                Specialty specialty = new Specialty(rs.getInt("s_id"),
//                        rs.getString("s_name"),
//                        rs.getInt("s_salary"));
//                sum += specialty.getS_salary();
//
//            }
//            System.out.println("Your project will cost :");
//            return sum;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return 0;
//    }

}