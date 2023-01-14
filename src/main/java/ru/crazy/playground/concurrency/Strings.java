package ru.crazy.playground.concurrency;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    public List<Integer> occurrences(String value, char c) {
        var l = new ArrayList<Integer>();
        var i = value.indexOf(c);
        while (i >= 0) {
            l.add(i);
            i = value.indexOf(c, i + 1);
        }
        return l;
    }
}
