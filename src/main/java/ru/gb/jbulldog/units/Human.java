package ru.gb.jbulldog.units;

import java.util.Objects;

public class Human {

    private String name;
    private Profession profession;

    public Human(final Profession profession) {
        this.profession = profession;
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, Profession profession) {
        this.name = name;
        this.profession = profession;
    }

    public Profession getProfession() {
        return profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public enum Profession {
        NONE(0),
        TRADER(1),
        FARMER(2),
        BANKER(3);

        private final int code;

        Profession(final int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }


}
