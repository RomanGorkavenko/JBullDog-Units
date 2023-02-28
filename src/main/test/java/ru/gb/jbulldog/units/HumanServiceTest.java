package ru.gb.jbulldog.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
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
        Assertions.assertEquals(expected, actual);
    }
}