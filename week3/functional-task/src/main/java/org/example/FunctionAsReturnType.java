package org.example;

import java.util.function.Function;

public class FunctionAsReturnType {
    Function<Integer, Integer> muliply(int x) {
        return y -> x * y;
    }
}
