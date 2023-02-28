package ru.gb.jbulldog.units;

public class Human {
    private final Profession profession;

    public Human(Profession profession) {
        this.profession = profession;
    }

    public Profession getProfession() {
        return profession;
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
