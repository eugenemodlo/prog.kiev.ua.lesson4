package ua.kiev.prog.lesson4;

import enumerators.SortOrder;

import java.util.Comparator;

public class StudentLastNameComparator implements Comparator<Student> {
    private final SortOrder sortOrder;

    StudentLastNameComparator(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (sortOrder == SortOrder.ASC) {
            return o1.getLastName().compareTo(o2.getLastName());
        } else {
            return o2.getLastName().compareTo(o1.getLastName());
        }

    }

}
