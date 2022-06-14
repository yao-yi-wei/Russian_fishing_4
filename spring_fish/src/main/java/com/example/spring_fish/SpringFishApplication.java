package com.example.spring_fish;

import com.example.spring_fish.process.RussiaFish;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringFishApplication {

    public static void main(String[] args) throws InterruptedException {

        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringFishApplication.class);
        ConfigurableApplicationContext run = builder.headless(false).run(args);
        RussiaFish russiaFish = (RussiaFish) run.getBean("russiaFish");
        russiaFish.startFishing(100);

    }

}
