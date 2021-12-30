package ru.crazy.playground.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crazy.playground.aop.PostContextConstruct;
import ru.crazy.playground.aop.Profiler;
import ru.crazy.playground.aop.RandomInt;

import javax.annotation.PostConstruct;

@Service
@Profiler
@RequiredArgsConstructor
public class IntBean implements IntGen {
    @RandomInt(min = -1488, max = -1487 )
    private int i;

    @Override
    @PostContextConstruct
    public void init() {
        System.out.println("Init variable i = " + i);
    }

    @Override
    public int getInt() {
        return i;
    }
}
