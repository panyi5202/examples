package com.roy.springboot.demo1;

import com.roy.springboot.demo1.domain.City;
import com.roy.springboot.demo1.service.CityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author Roy
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Resource
    private CityService cityService;

    /*public Application(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }*/

    @Override
    public void run(String... args) {
//        System.out.println(this.cityService.findByState("CA"));
        City city = new City();
        city.setName("cs");
        city.setState("hunan");
        city.setCountry("cn");
        this.cityService.addCity(city);
    }
}
