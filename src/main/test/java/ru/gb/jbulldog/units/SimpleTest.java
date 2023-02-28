package ru.gb.jbulldog.units;

import org.junit.jupiter.api.Test;

import java.util.function.*;

public class SimpleTest {

    Consumer<Integer> consumer = (i) -> System.out.println(i);
    BiConsumer<Integer, Float> biConsumer = (x, y) -> System.out.println(x + y);
    Function<Integer, String> function = (i) -> i.toString();
    Supplier<String> supplier = () -> "result";
    UnaryOperator<Integer> unaryOperator = (x) -> Math.abs(x);
    BinaryOperator<Integer> binaryOperator = (x, y) -> Math.max(x,y);

    @Test
    void name() {
        Predicate<String> predicate = (s) -> s.equals("Example");

        System.out.println(predicate.test("sting1"));

        System.out.println(predicate.test("sting2"));

        System.out.println(predicate.test("Example"));
    }

    @Test
    void name2(){
        consumer.accept(new Integer(1));
        consumer.accept(new Integer(2));
        consumer.accept(new Integer(3));
    }
}
