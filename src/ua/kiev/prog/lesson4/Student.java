package ua.kiev.prog.lesson4;

import enumerators.Sex;

public class Student extends Person {
    private String groupName;

    public Student(String firstName, String secondName, String lastName, Sex sex, int age) {
        super(firstName, secondName, lastName, sex, age);
    }

    public Student() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + getLastName() + " " + getFirstName() + " " + getSecondName() + '\'' +
                '}';
    }
}
