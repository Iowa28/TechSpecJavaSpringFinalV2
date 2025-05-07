package ru.aminovniaz.techspecjavaspringfinalv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Application {

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        System.setProperty("current_date", dateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
