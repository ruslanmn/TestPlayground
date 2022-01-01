package ru.crazy.playground.bpp.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.crazy.playground.bpp.PostContextConstruct;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class PostContextConstructListener implements ApplicationListener<ContextRefreshedEvent> {
    private final ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Arrays.stream(event.getApplicationContext().getBeanDefinitionNames())
                .forEach(beanDefName -> {
                    try {
                        var beanClass = factory.getBeanDefinition(beanDefName).getBeanClassName();
                        if (beanClass != null) {
                            Arrays.stream(Class.forName(beanClass).getMethods())
                                    .filter(method -> method.isAnnotationPresent(PostContextConstruct.class))
                                    .forEach(method -> {
                                        var bean = event.getApplicationContext().getBean(beanDefName);
                                        try {
                                            bean.getClass().getMethod(method.getName(), method.getParameterTypes())
                                                    .invoke(bean);
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                    });
                        }
                    } catch(Exception e){
                        throw new RuntimeException(e);
                    }
                });
    }
}
