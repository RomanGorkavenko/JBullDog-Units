package ru.gb.jbulldog.units;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        List<Human> list = new ArrayList<>();

        //List<Human> list = null;

        list.add(new Human(Human.Profession.TRADER));
        list.add(new Human(Human.Profession.FARMER));

        HumanService humanService = new HumanService();

        // Пример нарушения принципа Single responsibility.
        humanService.log.fine("45466");
        Logger log2 = humanService.log;
        log2.severe("2356");


        System.out.println(humanService.getHumansByProfessionCode(list, 1));
    }
}
