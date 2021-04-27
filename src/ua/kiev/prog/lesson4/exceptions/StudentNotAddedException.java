package ua.kiev.prog.lesson3.exceptions;

public class StudentNotAddedException extends Exception {

    @Override
    public String getMessage() {
        return "Group is Full!";
    }
}
