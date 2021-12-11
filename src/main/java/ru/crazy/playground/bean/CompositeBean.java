package ru.crazy.playground.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompositeBean {
    private final SingletonBean singletonBean;

    public String hello() {
        return "Hello!";
    }
}
