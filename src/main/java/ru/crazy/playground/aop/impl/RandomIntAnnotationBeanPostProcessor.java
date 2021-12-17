package ru.crazy.playground.aop.impl;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.crazy.playground.aop.RandomInt;

import java.util.Random;

@Component
public class RandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final Random gen = new Random();

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        for (var field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(RandomInt.class)) {
                var randIntAnnotation = field.getAnnotation(RandomInt.class);
                if (randIntAnnotation.min() >= randIntAnnotation.max()) {
                    throw new BeanInitializationException("Incorrect range for @" + RandomInt.class.getSimpleName()
                            + " at field " + field.getName());
                }
                field.setAccessible(true);
                field.setInt(bean,
                        gen.nextInt(randIntAnnotation.max() - randIntAnnotation.min())
                                + randIntAnnotation.min());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
