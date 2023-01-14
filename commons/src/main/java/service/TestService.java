package service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String getStr() {
        return "Hello! My name is Controller";
    }
}
