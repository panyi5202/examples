package com.roy.springboot.demo1.service;

import com.roy.springboot.demo1.domain.City;
import com.roy.springboot.demo1.mapper.CityMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Roy
 */
@Component
public class CityService {
    @Resource
    private CityMapper cityMapper;

    public City findByState(String state) {
        return this.cityMapper.findByState("CA");
    }

    @Transactional
    public void addCity(City city) {
        this.cityMapper.addCity(city);
    }
}
