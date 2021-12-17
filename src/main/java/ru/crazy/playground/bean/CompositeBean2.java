package ru.crazy.playground.bean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CompositeBean2 {
    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;

    public String hello() {
        log.info("Hello from {}", this.getClass().getSimpleName());
        return "o!";
    }
}
