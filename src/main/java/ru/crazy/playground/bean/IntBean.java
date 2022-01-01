package ru.crazy.playground.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crazy.playground.bpp.PostContextConstruct;
import ru.crazy.playground.bpp.Profiler;
import ru.crazy.playground.bpp.RandomInt;
import ru.crazy.playground.bpp.ReplaceImpl;

@Service
@Profiler
@ReplaceImpl(impl = Int1000Bean.class)
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
