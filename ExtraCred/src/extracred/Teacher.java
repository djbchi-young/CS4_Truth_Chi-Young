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
public class Teacher {
    private String name, subject;
    private ArrayList<Section> sections;
    
    public Teacher(String name, String subject){
        this.name = name;
        this.subject = subject;
        sections = new ArrayList();
    }
    
    public void addSection(Section s){
        sections.add(s);
    }
    
    public void giveAssignment(Assignment a){
        for(Section sec : sections){
            for(Student stu : sec.getStudents()){
                stu.addAssignment(a);
            }
        }
    }
}
