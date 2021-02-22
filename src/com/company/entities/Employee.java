package com.company.entities;

/**
 * create a class with all the fields
 */
public class Employee {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private int s_id;
/**
*constructor by default which accepts no arq
 */
    public Employee() {
    }
    /**
     * parameterized constructor
     * everything that i want to input my data
     */
    public Employee(String name, String surname, boolean gender, int s_id) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setS_id(s_id);
    }
    /**
     * parameterized constructor
     *  everything that i want to output my data
     */
    public Employee(int id, String name, String surname, boolean gender, int s_id) {
        setName(name);
        setSurname(surname);
        setGender(gender);

        setS_id(s_id);
        setId(id);
    }

    /**
     * all getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    @Override
    public String toString() {
        return "employee id: " + getId() + ", name: " + getName() + ", surname: " + getSurname() +
                ", gender " + getGender() + "  specialty id " + getS_id();
    }
}
