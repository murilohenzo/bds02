package com.devsuperior.bds02.mapper;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public CityDTO toDTO(City city) {
        return new CityDTO(city);
    }

    public City toEntity(CityDTO cityDTO) {
        City city = new City();
        city.setName(cityDTO.getName());
        return city;
    }
}
