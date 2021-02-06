package com.company;

import java.util.ArrayList;

public class Main {
    private ArrayList<Employee> project=new ArrayList<Employee>();

    public boolean addEmployeToProject(Employee employee){
        if(project.contains(employee)){
            System.out.println(employee.getEmpId()+" Already added inthe list");
            return false;
        }
        project.add(employee);
        return true;
    }

    public int numOfEmp(){

        return this.project.size();
    }

}
