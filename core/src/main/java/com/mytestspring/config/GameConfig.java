package com.mytestspring.config;

import com.mytestspring.GuessCount;
import com.mytestspring.MaxNumber;
import com.mytestspring.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "com.mytestspring")
public class GameConfig {

    // == field ==
    @Value("${game.maxNumber:50}")
    private int maxNumber;

    @Value("${game.guessCount:6}")
    private int guessCount;

    @Value("${game.minNumber:0}")
    private int minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
