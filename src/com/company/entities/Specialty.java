package com.company.entities;
/**
 * create a class with all the fields
 */
public class Specialty {
        private int s_id;
        private String s_name;
        private int s_salary;
    /**
     *constructor by default which accepts no arq
     */
        public Specialty() {}

        public Specialty(String name) {
            setName(name);
        }
    /**
     * parameterized constructor
     * everything that i want to input my data
     */
        public Specialty(int id, String name, int salary) {
            setId(id);
            setName(name);
            setS_salary(salary);
        }
        public Specialty(int id , int salary ){
            setId(id);
            setS_salary(salary);
        }

    public Specialty(int id, String s_name) {
            setId(id);
            setName(s_name);
    }

    /**
     * all getters and setters
     */
    public String getName() {
            return s_name;
        }

        public int getId() {
            return s_id;
        }

        public void setName(String name) {
            this.s_name = name;
        }

        public void setId(int id) {
            this.s_id = id;
        }

        public int getS_salary() {
        return s_salary;
        }

        public void setS_salary(int s_salary) {
            this.s_salary = s_salary;
        }

    @Override
        public String toString() {
            return "Specialty id: " + getId() + ", name: " + getName() + " salary: " + getS_salary();
        }
}
