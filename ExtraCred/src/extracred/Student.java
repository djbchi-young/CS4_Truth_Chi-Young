/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extracred;

import java.util.ArrayList;

/**
 *
 * @author rolandoyoung
 */
public class Student {
    private String name;
    private ArrayList<Assignment> assignments;
    
    public Student(String name){
        this.name = name;
        assignments = new ArrayList();
    }
    
    public void addAssignment(Assignment a){
        assignments.add(a);
    }
    
    public void finishAssignment(Assignment a){
        assignments.remove(a);
    }
    
    public  double getTimeNeeded(){
        double total = 0;
        
        for(Assignment a : assignments){
            total += a.getTimeAlotted();
        }
        
        return total;
    }

    public String getName() {
        return name;
    }
}
