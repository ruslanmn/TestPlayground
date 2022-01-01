package ru.crazy.playground.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crazy.playground.bpp.Profiler;

@Profiler
@RequiredArgsConstructor
public class Int1000Bean extends IntBean {
    @Override
    public int getInt() {
        return super.getInt() * 10;
    }
}
