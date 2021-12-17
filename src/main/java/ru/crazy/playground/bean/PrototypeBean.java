package ru.crazy.playground.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
public class PrototypeBean {
    public PrototypeBean() {
        log.error("[BEAN] {} was created", this.getClass().getSimpleName());
    }
}
