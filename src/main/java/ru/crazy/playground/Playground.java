package ru.crazy.playground;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.crazy.playground.aop.Profiler;
import ru.crazy.playground.aop.impl.ProfilerAnnotationBeanPostProcessor;
import ru.crazy.playground.bean.CompositeBean1;
import ru.crazy.playground.bean.IntGen;

public class Playground {
    @SneakyThrows
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.crazy.playground");
        var profiler = context.getBean(ProfilerAnnotationBeanPostProcessor.class);
        var b = context.getBean(IntGen.class);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Thread.sleep(1000);
            System.out.println(b.getInt());
        }
    }
}
