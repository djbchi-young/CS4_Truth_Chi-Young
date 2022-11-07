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
public class Section {
    private String name;
    private ArrayList<Student> students;
    
    public Section(String name){
        this.name = name;
        students = new ArrayList();
    }
    
    public void addStudent(Student s){
        getStudents().add(s);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
