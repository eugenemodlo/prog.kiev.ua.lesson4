package enumerators;

import java.util.HashMap;
import java.util.Map;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    private static final Map<String, Sex> LOOKUP_MAP = new HashMap<>();
    static {
        for (Sex sex:values()) {
            LOOKUP_MAP.put(sex.getSex(), sex);
        }
    }
    public static Sex getByString(String sex) {
        return LOOKUP_MAP.get(sex);
    }
}
