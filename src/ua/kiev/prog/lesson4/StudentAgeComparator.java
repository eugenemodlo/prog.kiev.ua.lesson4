package ua.kiev.prog.lesson4;

import enumerators.SortOrder;
import java.util.Comparator;

public class StudentAgeComparator implements Comparator {
    private SortOrder sortOrder;

    StudentAgeComparator(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }
    @Override
    public int compare(Object o1, Object o2) {
        Student firstStudent = (Student) o1;
        Student secondStudent = (Student) o2;

        if (sortOrder == SortOrder.ASC) {
            return firstStudent.getAge() - secondStudent.getAge();
        }
        if (sortOrder == SortOrder.DESC) {
            return  secondStudent.getAge() - firstStudent.getAge();
        }
        return 0;
    }

}
