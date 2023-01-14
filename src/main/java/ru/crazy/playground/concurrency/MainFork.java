package ru.crazy.playground.concurrency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

@Slf4j
public class MainFork {
    public static void main(String[] args) {
        var pool = ForkJoinPool.commonPool();
        var value = pool.invoke(new WordMixerTask("данил сегодня вкусно покушал"));
        log.info(value);
    }

    @Getter
    @RequiredArgsConstructor
    public static class WordMixerTask extends RecursiveTask<String> {
        private final String value;


        @Override
        protected String compute() {

            if (value.length() > 4) {
                var left = new WordMixerTask(value.substring(0, value.length() / 2));
                var right = new WordMixerTask(value.substring(value.length() / 2));
                invokeAll(left, right);
                return left.join() + right.join();
            } else {
                List<Character> v = value.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
                Collections.shuffle(v);
                return v.stream().map(String::valueOf).collect(Collectors.joining());
            }
        }
    }
}
