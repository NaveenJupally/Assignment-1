package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private String name;
    private double salary;
    private int age;
    private int uniqueIdentifier;


    public Employee(String name, double salary, int age, int uniqueIdentifier) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public int getEmpId() {

        return uniqueIdentifier;
    }
    private static ArrayList<Employee>
            arrayList=new ArrayList<Employee>();
    private static Scanner scanner = new Scanner(System.in);

//select option
    public static void askUserChoice(){
        while (true) {
            System.out.println("1.Create Employee");
            System.out.println("2.Update Employee");
            System.out.println("3.Delete Employee");
            System.out.println("4.List Of Employee");
            System.out.println("5.Go to Project");
            System.out.println("Choose Your Choice !");
            ProcessUserChoice(scanner.nextInt());
        }
    }


    public static void ProcessUserChoice(int choice){

        switch (choice){
            case 1:
                final Employee employees=createEmployee();
                arrayList.add(employees);
                break;
            case 2:
                System.out.println("Enter empid to Update ");
                updateEmployee(scanner.nextInt());
                break;

            case 3:
                System.out.println("Enter Employee to delete ");
                deleteEmployee(scanner.nextInt());
            case 4:
                empList();
                break;
            case 5:
                Project.askUserChoice();
                break;
        }
    }

    //Create employee method
    public static Employee createEmployee()
    {

        System.out.println("Enter employee details !");
        final String name=takeName();
        System.out.println("Enter Salary : ");
        double salary = scanner.nextDouble();
        System.out.println("Enter Age : ");
        int age = scanner.nextInt();


        Employee employee=createEmployeeObject(name,salary,age);
        employee.displayInformation();

        return employee;

    }


    public static String takeName(){
        System.out.print("Name: ");
        final String name=scanner.next();
        if (!isNameValid(name)) {
            return takeName();
        }
        else {
            return name;
        }
    }

    private static boolean isNameValid(String name){
        final boolean matches=name.matches("[a-zA-Z]*$");
        if(!matches) {
            System.out.println("Looks like Invalid");
        }
        return matches;
    }
    public void displayInformation() {
        System.out.println(name + "," + salary + "," + age+","+uniqueIdentifier );

    }

    private static int identifier=1;
    private static Employee createEmployeeObject(String name,double salary,int age){
        return new Employee(name,salary,age,identifier++);
    }
//Update employee
    public static void updateEmployee(int empId){
        boolean isEmployeeFound=false;
        for (int i=0;i<arrayList.size();i++){
            isEmployeeFound=arrayList.get(i).getEmpId()==(empId);

            if (isEmployeeFound){
                System.out.println("Enter update info with id : "+empId);
                System.out.println("Enter name : ");
                String name = scanner.next();
                System.out.println("Enter Salary : ");
                double salary = scanner.nextDouble();
                System.out.println("Enter Age : ");
                int age = scanner.nextInt();

                arrayList.get(i).update(name,salary,age);
                break;
            }
            if (!isEmployeeFound){
                System.out.println("Employe Not Exist ");
            }
        }
    }

    private void update(String name, double salary, int age) {
        this.name=name;
        this.salary = salary;
        this.age = age;

    }


//Delete Employee
    private static void deleteEmployee(int empId) {
        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).getEmpId()==(empId)){
                arrayList.remove(i);
                System.out.println("Employee with Id: "+empId+" removed");
            }
        }
    }

    //List of employees method
    public static void empList(){
        for (Employee e:arrayList){
            e.displayInformation();
        }
    }

}