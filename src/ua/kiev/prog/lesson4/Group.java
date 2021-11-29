package ua.kiev.prog.lesson4;

import enumerators.Sex;
import enumerators.SortOrder;
import enumerators.SortType;
import ua.kiev.prog.lesson4.exceptions.StudentNotAddedException;
import ua.kiev.prog.lesson4.exceptions.StudentNotFoundException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

@SuppressWarnings("squid:S106")
public class Group implements MilitaryRecruit {
    private static final int MAX_STUDENTS_AMOUNT = 10;
    private String groupName;
    private final Student[] students = new Student[MAX_STUDENTS_AMOUNT];

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }

    public Student[] getStudents() {
        return students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student student) throws StudentNotAddedException {
        for (int i = 0; i <= MAX_STUDENTS_AMOUNT; i++) {
            if (i == MAX_STUDENTS_AMOUNT) throw new StudentNotAddedException();
            if (students[i] == null) {
                students[i] = student;
                student.setGroupName(this.groupName);
                System.out.println("student " + student.getLastName() + " " + student.getFirstName() + " added!");
                break;
            }
        }
    }

    public void addStudentInteractive() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adding a new student to group!");
        System.out.print("Enter a Last Name: ");
        student.setLastName(scanner.nextLine());

        System.out.print("Enter a First Name: ");
        student.setFirstName(scanner.nextLine());

        System.out.print("Enter a Second Name: ");
        student.setSecondName(scanner.nextLine());

        System.out.print("Enter a sex (Male/Female): ");
        String sexStr;
        do {
            sexStr = scanner.nextLine();
        } while (!sexStr.equals("Male") && !sexStr.equals("Female"));
        student.setSex(Sex.getByString(sexStr));

        System.out.print("Enter an age: ");
        student.setAge(scanner.nextInt());
        scanner.close();

        try {
            addStudent(student);
        } catch (StudentNotAddedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        Arrays.sort(students, (o1, o2) -> CheckNull.checkNull(o1, o2) != CheckNull.NOT_NULL ? CheckNull.checkNull(o1, o2) :
                o1.getLastName().compareTo(o2.getLastName()));

        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public Student getStudentByLastName(String lastName) throws StudentNotFoundException {
        Student stud = null;
        for (Student student : this.students) {
            if (student != null && student.getLastName().equals(lastName)) {
                stud = student;
            }
        }
        if (stud == null) {
            throw new StudentNotFoundException();
        }
        return stud;
    }

    public boolean removeStudent(String lastName) throws StudentNotFoundException {
        for (int i = 0; i <= students.length; i++) {
            if (i == students.length) {
                throw new StudentNotFoundException();
            }
            if (students[i].getLastName().equals(lastName)) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public void sortStudentsBy(SortType sortType, SortOrder sortOrder) {
        switch (sortType) {
            case AGE -> Arrays.sort(this.students, new StudentAgeComparator(sortOrder));
            case LAST_NAME -> Arrays.sort(this.students, new StudentLastNameComparator(sortOrder));
        }

    }

    @Override
    public Student[] getRecruitersArray() {
        return Arrays.stream(students).filter(Objects::nonNull).filter(item -> item.getAge() >= 18).toArray(Student[]::new);
    }
}
