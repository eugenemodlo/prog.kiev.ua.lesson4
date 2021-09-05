package ua.kiev.prog.lesson4.exceptions;

public class StudentNotAddedException extends Exception {

    @Override
    public String getMessage() {
        return "Group is Full!";
    }
}
