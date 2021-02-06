package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Project {
    private String ProjectName;

    private String technology;
    private String duration;
    private int uniqueIdentifier;

    public Project(String projectName, String technology, String duration, int uniqueIdentifier) {
        ProjectName = projectName;
        this.technology = technology;
        this.duration = duration;
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public int getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    private static ArrayList<Project> project=new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    //select option
    public static void askUserChoice(){
        while (true) {
            System.out.println("1.Create Project");
            System.out.println("2.Update Project");
            System.out.println("3.Delete Project");
            System.out.println("4.List Of Emplees");
            System.out.println("5.Go to Emplees");
            System.out.println("Choose Your Choice !");
            ProcessUserChoice(scanner.nextInt());
        }
    }


    public static void ProcessUserChoice(int choice){

        switch (choice){
            case 1:
                final Project projects=createProject();
                project.add(projects);
                break;

            case 2:
                System.out.println("Enter empid to Update ");
                updateProject(scanner.nextInt());
                break;

            case 3:
                System.out.println("Enter Employee to delete ");
                deleteProject(scanner.nextInt());
                break;
            case 4:
                empList();
                break;
            case 5:
                Employee.askUserChoice();
                break;
        }
    }

    //Create employee method
    public static Project createProject()
    {

        System.out.println("Enter Project details !");
        System.out.println("Enter ProjectName : ");
        String ProjectName = scanner.next();
        System.out.println("Enter technology : ");
        String technology = scanner.next();
        System.out.println("Enter Duration : ");
        String  duration = scanner.next();



        Project project=createProjectObject(ProjectName,technology,duration);
        project.displayInformation();
        return project;

    }
    public void displayInformation() {
        System.out.println(ProjectName + "," + technology + "," + duration+","+uniqueIdentifier );

    }
    private static int id=1;
    private static Project createProjectObject(String projectName,String technology,String duration){
        return new Project(projectName,technology,duration,id++);
    }
    //Update employee
    public static void updateProject(int empId){
        boolean isEmployeeFound=false;
        for (int i=0;i<project.size();i++){
            isEmployeeFound=project.get(i).getUniqueIdentifier()==(empId);

            if (isEmployeeFound){
                System.out.println("Enter update info with id : "+empId);
                System.out.println("Enter ProjectName : ");
                String ProjectName = scanner.next();
                System.out.println("Enter technology : ");
                String technology = scanner.next();
                System.out.println("Enter Duration : ");
                String  duration = scanner.next();

                project.get(i).update(ProjectName,technology,duration);
                break;
            }
            if (!isEmployeeFound){
                System.out.println("Employe Not Exist ");
            }
        }
    }

    private void update(String ProjectName, String  technology, String duration) {
        this.ProjectName=ProjectName;
        this.technology = technology;
        this.duration = duration;

    }


    //Delete Employee
    private static void deleteProject(int empId) {
        for (int i=0;i<project.size();i++){
            if (project.get(i).getUniqueIdentifier()==(empId)){
                project.remove(i);
                System.out.println("Employee with Id: "+empId+" removed");
            }
        }
    }

    //List of employees method
    public static void empList(){
        for (Project e:project){

            e.displayInformation();
        }
    }
}
