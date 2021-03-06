package ru.crazy.playground.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SingletonBean {
    public SingletonBean() {
        log.error("[BEAN] {} was created", this.getClass().getSimpleName());
    }
}
