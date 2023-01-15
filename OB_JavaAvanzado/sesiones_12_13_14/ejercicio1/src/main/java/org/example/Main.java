package org.example;

import static org.example.Employee.*;

public class Main {
    public static void main(String[] args) {

        Employee.addEmployee(new Employee("Ona", "Garniu", 45, Workplace.MANAGER));
        Employee.addEmployee(new Employee("Kai", "Otton", 32, Workplace.ADMINISTRATIVE));
        Employee.addEmployee(new Employee("Koa", "Kalani", 56, Workplace.MECHANIC));
        Employee.addEmployee(new Employee("Alex", "Garcia", 49, Workplace.MECHANIC));

        System.out.println(getEmployeeByName("Ona"));

        System.out.println(getAllEmployees());
    }
}