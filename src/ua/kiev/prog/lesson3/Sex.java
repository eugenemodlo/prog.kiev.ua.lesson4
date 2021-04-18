package ua.kiev.prog.lesson3;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }
}
