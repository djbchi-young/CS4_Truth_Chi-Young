/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extracred;

/**
 *
 * @author rolandoyoung
 */
public class ExtraCred {

    /*
Teacher t1: teaches Section c1 and c2
Teacher t2: teaches Section c2
Teacher t3: teaches Section c1
Section c1: has Student s1 and s2
Section c2: has Student s3
Assignment a1: has timeAllotted 2
Assignment a2: has timeAllotted 3
Assignment a3 has timeAllotted 5
And additional Student instances s1, s2, and s3
     */
    public static void main(String[] args) {
        
        //initial objects
        Teacher t1 = new Teacher("Dhinz", "Chem"), t2 = new Teacher("Tarcy", "CompSci"), t3 = new Teacher("Nat", "Math");
        Section c1 = new Section("Strange"), c2 = new Section("Beauty");
        Student s1 = new Student("Michael"), s2 = new Student("Jerry"), s3 = new Student("Lisa");
        Assignment a1 = new Assignment(2), a2 = new Assignment(3), a3 = new Assignment(5);
        
        //sets section of teachers
        t1.addSection(c1);
        t1.addSection(c2);
        t2.addSection(c2);
        t3.addSection(c1);
        
        //sets students of section
        c1.addStudent(s1);
        c1.addStudent(s2);
        c2.addStudent(s3);
        
        t1.giveAssignment(a1);
        t2.giveAssignment(a2);
        t3.giveAssignment(a3);
        s2.finishAssignment(a1);
        System.out.printf("%s remaining work: %.2f%n", s1.getName(), s1.getTimeNeeded());
        System.out.printf("%s remaining work: %.2f%n", s2.getName(), s2.getTimeNeeded());
        System.out.printf("%s remaining work: %.2f%n", s3.getName(), s3.getTimeNeeded());
    }
    
}
