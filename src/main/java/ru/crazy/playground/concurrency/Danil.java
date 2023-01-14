package ru.crazy.playground.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class Danil {
    private ThreadLocal<Float> gayness;

    public Danil() {
        this.gayness = new ThreadLocal<>();
    }

    public void gaynerate() {
        try {
            Optional.ofNullable(gayness.get())
                    .ifPresentOrElse(
                            g -> log.info("Name already presented and equals {}", gayness.get()),
                            () -> {
                                log.info("No name found. Gaynerating...");
                                var g = GayUtils.random();
                                gayness.set(g);
                                log.info("So it be " + g);
                            });
        } catch (Exception ex) {
            log.error("Error", ex);
        }
    }

    public float getGayness() {
        return gayness.get();
    }
}