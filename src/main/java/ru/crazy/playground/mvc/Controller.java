package ru.crazy.playground.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.crazy.playground.bean.CompositeBean;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final CompositeBean compositeBean;

    @GetMapping("/hello")
    public String getHello() {
        return compositeBean.hello();
    }
}
