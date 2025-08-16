package org.example;

import java.util.function.Consumer;

public class FunctionAsArgument {
    void register(String name, Consumer<String> callback){
        callback.accept(name + "@gmail.com");
    }
    Consumer<String> welcomeMail = mail -> System.out.println("Mailing " + mail);
}
