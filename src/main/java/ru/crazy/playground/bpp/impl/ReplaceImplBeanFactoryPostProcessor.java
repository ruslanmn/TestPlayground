package ru.crazy.playground.bpp.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.crazy.playground.bpp.ReplaceImpl;

import java.util.Arrays;

@Component
public class ReplaceImplBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Arrays.stream(configurableListableBeanFactory.getBeanDefinitionNames())
                .map(configurableListableBeanFactory::getBeanDefinition)
                .forEach(beanDef -> {
                    var beanClassName = beanDef.getBeanClassName();
                    Class<?> beanClass;
                    try {
                        beanClass = Class.forName(beanClassName);
                        if (beanClass.isAnnotationPresent(ReplaceImpl.class)) {
                            var newImpl = beanClass.getAnnotation(ReplaceImpl.class).impl();
                            beanDef.setBeanClassName(newImpl.getName());
                        }
                    } catch (Exception ex) {
                    }
                });
    }
}
