package de.ksbrwsk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfiguration {

    @Bean
    public TaskProcessor taskProcessor() {
        return new TaskProcessor();
    }
}
