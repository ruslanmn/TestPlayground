package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestServiceConfig {
    @Bean
    public TestService testService() {
        return new TestService();
    }
}
