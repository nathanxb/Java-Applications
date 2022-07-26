package StudentDatabaseApp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeLevel;
    private String stringGrade;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor
    Student() {
        // Enter name and year for each student
        getStudentInfo();

        // Each student should have a 5-digit unique ID, first number is their grade level
        setStudentID();

        id++;
    }
    // Methods:
    // Get Student Information

    private void setStudentID() {
        // Grade + ID
        this.studentID = gradeLevel + "" + id;
    }

    private void getStudentInfo() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student grade level(1-4):");
        this.gradeLevel = in.nextInt();
    }

    // Choose course (each course is $600)
    public void enroll() {
        // Loop, user hits Q when done enrolling
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n    " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
    }


    // Student should be able to view their balance and pay the tuition
    public void viewBalance() {
        System.out.println("Your remaining balance is : $" + tuitionBalance);
    }
    public void payTuition() {
        Scanner in = new Scanner(System.in);
        System.out.println("Your current balance is: $" + tuitionBalance);
        System.out.print("How much of your balance would you like to pay now? $");
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    public String gradeToString(int gradeLevel) {
        if (gradeLevel == 1){
            stringGrade = "Freshman";
        } else if (gradeLevel == 2) {
            stringGrade = "Sophomore";
        }
        else if (gradeLevel == 3) {
            stringGrade = "Junior";
        }
        else if (gradeLevel == 4) {
            stringGrade = "Senior";
        } else {
            return "";
        }
        return stringGrade;
    }

    // Student status should show: ID, courses enrolled, and balance
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeToString(gradeLevel) +
                "\nStudent ID: " + studentID +
                "\nEnrolled in: " + courses +
                "\nAccount Balance: $" + tuitionBalance;
    }
}
