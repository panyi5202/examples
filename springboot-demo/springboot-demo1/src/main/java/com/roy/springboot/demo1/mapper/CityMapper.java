package com.roy.springboot.demo1.mapper;

import com.roy.springboot.demo1.domain.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Roy
 */
@Mapper
public interface CityMapper {

    @Select("select id, name, state, country from city where state = #{state}")
    City findByState(@Param("state") String state);

    @Insert("insert into city(name, state, country) values(#{city.name},#{city.state},#{city.country})")
    void addCity(@Param("city") City city);
}
