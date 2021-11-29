package ua.kiev.prog.lesson4;

import enumerators.SortOrder;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {
    private final SortOrder sortOrder;

    StudentAgeComparator(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Student o1, Student o2) {

        if (o1 == null) return -1;
        if (o2 == null) return 1;

        if (sortOrder == SortOrder.ASC) {
            return o1.getAge() - o2.getAge();
        } else {
            return o2.getAge() - o1.getAge();
        }

    }

}
