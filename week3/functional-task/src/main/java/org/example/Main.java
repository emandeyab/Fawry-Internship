package org.example;


public class Main {
    public static void main(String[] args) {
        //1
        System.out.println("##  Emxample on function as variable  ##");
        FunctionAsVariable functionAsVariable = new FunctionAsVariable();
        System.out.println(functionAsVariable.add.apply(4,5));

        //2
        System.out.println("##  Emxample on function as return type  ##");
        FunctionAsReturnType functionAsReturnType = new FunctionAsReturnType();
        System.out.println(functionAsReturnType.muliply(2).apply(2));
        System.out.println(functionAsReturnType.muliply(3).apply(2));
        System.out.println(functionAsReturnType.muliply(4).apply(2));
        System.out.println(functionAsReturnType.muliply(5).apply(2));

        //3
        System.out.println("## Emxample on function as argument  ##");
        FunctionAsArgument functionAsArgument = new FunctionAsArgument();
        functionAsArgument.register("Eman", functionAsArgument.welcomeMail);
    }
}