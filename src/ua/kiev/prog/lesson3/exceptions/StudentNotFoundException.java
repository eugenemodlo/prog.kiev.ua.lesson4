
package ua.kiev.prog.lesson3.exceptions;

public class StudentNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Student not found!";
    }
}

