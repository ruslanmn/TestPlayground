package ru.crazy.playground.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {CompositeBean.class, SingletonBean.class})
public class CompositeBeanTest {

    @Autowired
    CompositeBean compositeBean;

    @Test
    void beansInitTest() {
        compositeBean.hello();
    }
}
