package controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by gwenli on 2017-09-19.
 */
@ComponentScan("controllers")
@SpringBootApplication
public class Application {
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
