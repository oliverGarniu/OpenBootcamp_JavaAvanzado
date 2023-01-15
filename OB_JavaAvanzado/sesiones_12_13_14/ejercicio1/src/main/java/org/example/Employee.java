package org.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String surname;
    private int age;
    private Workplace workplace;
    static List<Employee> employees = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, String surname, int age, Workplace workplace) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workplace = workplace;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    //    función para añadir nuevos empleados a la lista;
    public static void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.printf("El empleado %s se ha añadido correctamente.\n", employee.getName());
    }

    //    función para obtener la info de un empleado a partir de su nombre.
    public static Employee getEmployeeByName(String name) {
        return employees.stream()
                .filter(employee -> name.equals(employee.getName()))
                .findFirst().orElse(null);
    }

    //    función para obtener todos los empleados de la lista.
    public static List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", workplace=" + workplace +
                '}';
    }
}

// clase enum con los distintos puestos de trabajo.
enum Workplace {
    ADMINISTRATIVE, MECHANIC, MANAGER
}
