package ru.crazy.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.crazy.playground.bean.CompositeBean1;

public class Playground {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.crazy.playground");
        var b = context.getBean(CompositeBean1.class);
        //System.out.println(b.getInt());
    }
}
