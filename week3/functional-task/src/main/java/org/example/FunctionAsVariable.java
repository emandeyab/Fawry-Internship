package org.example;

import java.util.function.BiFunction;

public class FunctionAsVariable {
    BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
    //System.out.println(add.apply(4.5));
}
