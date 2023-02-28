package ru.gb.jbulldog.units;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class HumanService {
    /*
    * Нарушен принцип Single responsibility,
    * каждый класс должен иметь только одну ответственность,
    * которая должна быть инкапсулирована в этом классе.
    * Поле Logger должно быть объявлено как: private final Logger log;*/
    Logger log;
    private final HumanRepository humanRepository;

    public HumanService() {
        this.log = Logger.getLogger(HumanService.class.getName());
        this.humanRepository = new HumanRepository();
    }

    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    /*
    * Метод getHumansByProfessionCode без модификатора доступа (package private)
    * в данном конкретном примере не нарушает принципов SOLID,
    * но если нам понадобится с ним взаимодействовать в классе из другого пакета,
    * то может быть нарушен принцип Open-closed,
    * но я не уверен в этом.*/
    List<Human> getHumansByProfessionCode(final List<Human> humans, final int code){
        if(humans == null || humans.isEmpty()){
            log.fine("Empty humans list!");
            return new ArrayList<Human>();
        }

        boolean flag = false;
        for(final Human.Profession p: Human.Profession.values()){
            if (p.getCode() == code) {
                flag = true;
                break;
            }
        }
        if(!flag){
            log.severe("Non valid code");
            throw new IllegalStateException("Non valid code");
        }

        final List<Human> result = new ArrayList<Human>();
        for (final Human human : humans) {
            if (human.getProfession().getCode() == code) {
                result.add(human);
            }
        }
        log.fine(String.format("Find %s items.", result.size()));

        return result;
    }

    public List<Human> getOrderedAllHumans() {
        List<Human> humans = humanRepository.getAll();
        //...
        return humans;
    }

    public Human getHumansByName(String name) {
        Human human = humanRepository.getHumanByName(name);
        //...
        return human;
    }
}
