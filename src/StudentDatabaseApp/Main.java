package StudentDatabaseApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Hard code prior to creating for-loop
//        Student stu1 = new Student();
//        stu1.enroll();
//        stu1.payTuition();
//        System.out.println("----------------------------------");
//        System.out.println(stu1.toString());
        // Ask how many new users we want to add
        System.out.print("Enter number of students you would like to enroll:");
        Scanner in = new Scanner(System.in);
        int numNewStudents = in.nextInt();
        Student[] students = new Student[numNewStudents];

        // Create n number of new students
        for (int n=0; n < numNewStudents; n++) {
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
            System.out.println("----------------------------------");
            System.out.println(students[n].toString());
        }
    }
}
