package Collections;

import java.util.Map;
import java.util.Set;

public class Characters {
    private String name;
    private int age;
    private Map<String, Set<String>> talents;

    public Characters(String name, int age, Map<String, Set<String>> talents) {
        this.name = name;
        this.age = age;
        this.talents = talents;
    }

    public boolean haveTalent(String field, String talent) {
        for (Map.Entry<String, Set<String>> entry : talents.entrySet()) {
            if (entry.getKey().equals(field)) {
                for (String talentCharacter : entry.getValue()) {
                    if (talentCharacter.equals(talent)) return true;
                }
            }
        }
        return false;
    }
}

