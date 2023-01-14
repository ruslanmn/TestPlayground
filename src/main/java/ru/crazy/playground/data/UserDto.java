package ru.crazy.playground.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    String name;
    String surname;
}
