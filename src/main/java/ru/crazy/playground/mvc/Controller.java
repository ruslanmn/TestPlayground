package ru.crazy.playground.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.crazy.playground.bean.CompositeBean1;
import ru.crazy.playground.bean.CompositeBean2;
import ru.crazy.playground.bean.IntBean;
import ru.crazy.playground.bean.IntGen;
import ru.crazy.playground.bean.RequestBean;

@Scope("request")
@RestController
@RequiredArgsConstructor
public class Controller {
    private final CompositeBean1 compositeBean1;
    private final CompositeBean2 compositeBean2;
    private final RequestBean requestBean;
    private final IntGen intBean;

    @GetMapping("/hello")
    public String getHello() {
        return compositeBean1.hello() + compositeBean2.hello()
                + " " + requestBean.name(this.getClass().getSimpleName());
    }

    @GetMapping("/int")
    public int getInt() {
        return intBean.getInt();
    }
}
