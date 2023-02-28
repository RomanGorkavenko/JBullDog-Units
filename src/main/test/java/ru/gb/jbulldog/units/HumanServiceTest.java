package ru.gb.jbulldog.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HumanServiceTest {

    private HumanRepository humanRepository;
    HumanService humanService;

    @BeforeEach
    void setUp() {
        List<Human> humanList = new ArrayList<Human>();
        humanList.add(new Human(Human.Profession.TRADER));
        humanList.add(new Human(Human.Profession.FARMER));
        humanList.add(new Human(Human.Profession.NONE));
        Human human = new Human("Alex", Human.Profession.FARMER);
        Human human2 = new Human("Sasha", Human.Profession.BANKER);
        humanRepository = Mockito.mock(HumanRepository.class);
        Mockito.when(humanRepository.getAll()).thenReturn(humanList);
        Mockito.when(humanRepository.getHumanByName("Alex")).thenReturn(human);
        Mockito.when(humanRepository.getHumanByName("Sasha")).thenReturn(human2);
        Mockito.when(humanRepository.getHumanByName("Olga")).thenThrow(IllegalStateException.class);
        humanService = new HumanService(humanRepository);
    }

    @Test
    void getOrderedAllHumansTest() {
        List<Human> expected = new ArrayList<>();
        List<Human> actual = new ArrayList<>();
        actual = humanService.getOrderedAllHumans();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void getHumansByNameTest(){
        Human expected = new Human("Alex");
        Human actual = humanService.getHumansByName("Olga");
        this.humanService = new HumanService();
    }

    @Test
    void getHumansByProfessionCodeTestFailureArrayListIsEmpty() {
        List<Human> list = new ArrayList<>();

        int code = 0;

        List<Human> expected = new ArrayList<>();

        List<Human> actual = humanService.getHumansByProfessionCode(list,code);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHumansByProfessionCodeTestFailureArrayListNull() {
        List<Human> list = null;

        int code = 0;

        List<Human> expected = new ArrayList<>();

        List<Human> actual = humanService.getHumansByProfessionCode(list,code);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHumansByProfessionCodeTestFailureNonValidCode() {
        List<Human> list = new ArrayList<>(Arrays.asList(new Human(Human.Profession.TRADER)));

        int code = 9;

        IllegalStateException exc = Assertions.assertThrows(IllegalStateException.class, () -> {
            humanService.getHumansByProfessionCode(list, code);
        });

        Assertions.assertEquals("Non valid code", exc.getMessage());
    }

    @Test
    void getHumansByProfessionCodeTestSuccessfulArrayList() {
        List<Human> list = new ArrayList<>();
        list.add(new Human(Human.Profession.TRADER));
        list.add(new Human(Human.Profession.BANKER));
        list.add(new Human(Human.Profession.NONE));
        list.add(new Human(Human.Profession.FARMER));
        list.add(new Human(Human.Profession.TRADER));

        int code = 1;

        List<Human> expected = new ArrayList<>(Arrays.asList(list.get(0), list.get(4)));

        List<Human> actual = humanService.getHumansByProfessionCode(list,code);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHumansByProfessionCodeTestSuccessfulAllValuesAreNotEqualCode() {
        List<Human> list = new ArrayList<>();
        list.add(new Human(Human.Profession.TRADER));
        list.add(new Human(Human.Profession.BANKER));
        list.add(new Human(Human.Profession.FARMER));
        list.add(new Human(Human.Profession.FARMER));
        list.add(new Human(Human.Profession.TRADER));

        int code = 0;

        List<Human> expected = new ArrayList<>();

        List<Human> actual = humanService.getHumansByProfessionCode(list,code);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHumansByProfessionCodeTestSuccessfulAllValuesEqualCode() {
        List<Human> list = new ArrayList<>();
        list.add(new Human(Human.Profession.BANKER));
        list.add(new Human(Human.Profession.BANKER));
        list.add(new Human(Human.Profession.BANKER));
        list.add(new Human(Human.Profession.BANKER));
        list.add(new Human(Human.Profession.BANKER));

        int code = 3;

        List<Human> expected = list;

        List<Human> actual = humanService.getHumansByProfessionCode(list,code);

        Assertions.assertEquals(expected, actual);
    }
}