package ru.crazy.playground.mbean;

import lombok.Data;

@Data
public class ProfilerToggle implements ProfilerToggleMBean {
    private boolean enabled = true;
}
