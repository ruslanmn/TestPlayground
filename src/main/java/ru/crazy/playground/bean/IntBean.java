package ru.crazy.playground.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crazy.playground.aop.RandomInt;

@Service
@RequiredArgsConstructor
public class IntBean {
    @RandomInt(min = -1488, max = -1487)
    private int i;

    public int getInt() {
        return i;
    }
}
