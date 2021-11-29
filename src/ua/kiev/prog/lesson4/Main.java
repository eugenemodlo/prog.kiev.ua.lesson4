package ua.kiev.prog.lesson4;

import enumerators.Sex;
import enumerators.SortOrder;
import enumerators.SortType;
import ua.kiev.prog.lesson4.exceptions.StudentNotAddedException;
import ua.kiev.prog.lesson4.exceptions.StudentNotFoundException;

import java.util.Arrays;

@SuppressWarnings("squid:S106")
public class Main {
    public static void main(String[] args) {
        Student studentOne = new Student("John", "Doe", "Rambo", Sex.MALE, 34);
        Student studentTwo = new Student("Abraham", "Doe", "Lincoln", Sex.MALE, 24);
        Student studentThree = new Student("Henry", "Doe", "Ford", Sex.MALE, 35);
        Student studentFour = new Student("Jonny", "Doe", "Mnemonic", Sex.MALE, 44);
        Student studentFive = new Student("Forest", "Doe", "Hamp", Sex.MALE, 24);
        Student studentSix = new Student("Miranda", "Doe", "Priestly", Sex.FEMALE, 36);
        Student studentSeven = new Student("Scarlett", "Doe", "O'hara", Sex.FEMALE, 37);
        Student studentEight = new Student("Maria", "Doe", "Cure", Sex.FEMALE, 22);
        Student studentNine = new Student("Liza", "Doe", "Minelly", Sex.FEMALE, 23);
        Student studentTen = new Student("Lilu", "Doe", "Dallas", Sex.FEMALE, 30);
        Student studentZero = new Student("Terra", "Doe", "Incognita", Sex.FEMALE, 29);

        Group group = new Group("AA-00");

        System.out.println("STEP 1: Add ten students");

        try {
            group.addStudent(studentOne);
            group.addStudent(studentTwo);
            group.addStudent(studentThree);
            group.addStudent(studentFour);
            group.addStudent(studentFive);
            group.addStudent(studentSix);
            group.addStudent(studentSeven);
            group.addStudent(studentEight);
            group.addStudent(studentNine);
            group.addStudent(studentTen);

        } catch (StudentNotAddedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("STEP 2: Print group sorted by last name");
        System.out.println(group);

        System.out.println("STEP 3: Add students 11 with exception");
        try {
            group.addStudent(studentZero);
        } catch (StudentNotAddedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("STEP 4: Find student with last name - Hamp");

        try {
            System.out.println(group.getStudentByLastName("Hamp"));
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("STEP 5: Delete student");

        try {
            if (group.removeStudent("Hamp")) {
                System.out.println("Student successfully removed!");
            }
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("STEP 6: Try to find deleted student");
        try {
            System.out.println(group.getStudentByLastName("Hamp"));
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

//        System.out.println("STEP 7: Interactive add student");
//        group.addStudentInteractive();

        System.out.println("STEP 8: Comparator test");
        group.sortStudentsBy(SortType.AGE, SortOrder.ASC);

        System.out.println("STEP 9: Military interface test");
        Arrays.stream(group.getRecruitersArray()).forEach(item -> System.out.println(item));
    }
}