package ru.crazy.playground.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("request")
public class RequestBean {
    public RequestBean() {
        log.error("[BEAN] {} was created", this.getClass().getSimpleName());
    }

    public String name(String name) {
        return "My name is " + name;
    }
}
