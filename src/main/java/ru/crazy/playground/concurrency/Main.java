package ru.crazy.playground.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        var danil = new Danil();
        var cores = Runtime.getRuntime().availableProcessors();
        log.info("Available cores = {}", cores);
        var ruslan = Executors.newScheduledThreadPool(cores);

        for (int i = 0; i < 1000; i++) {
            ruslan.scheduleAtFixedRate(danil::gaynerate, 0, 1, TimeUnit.MILLISECONDS);
        }

        ruslan.awaitTermination(1488, TimeUnit.SECONDS);
    }
}


