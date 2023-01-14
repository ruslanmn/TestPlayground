package ru.crazy.playground.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.crazy.playground.bean.CompositeBean1;
import ru.crazy.playground.bean.CompositeBean2;
import ru.crazy.playground.bean.IntGen;
import ru.crazy.playground.data.UserDto;
import service.TestService;
import service.TestServiceConfig;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final CompositeBean1 compositeBean1;
    private final CompositeBean2 compositeBean2;
    private final IntGen intBean;
    private final TestService testService;

    @GetMapping("/hello")
    public String getHello() {
//        compositeBean1.hello() + compositeBean2.hello()
//                + " " + requestBean.name(this.getClass().getSimpleName());
        return testService.getStr();
    }

    @GetMapping("/int")
    public int getInt(Specification<UserDto> userFilter, Pageable pageable) {
        return intBean.getInt();
    }
}
