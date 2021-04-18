package ua.kiev.prog.lesson3;

public interface CheckNull {
    int NOT_NULL = 7;

    static int checkNull(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return NOT_NULL;
    }

}
