package com.devsuperior.bds02.services;

import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CityService {
    private CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> findAllCities() {
        return repository.findAll().stream().sorted(Comparator.comparing(City::getName)).collect(Collectors.toList());
    }

    public City createCity(City city) {
        return repository.save(city);
    }

    public void deleteCity(Long id) {
        City existCity = this.findById(id);
        repository.deleteById(existCity.getId());
    }

    public City findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("City not found"));
    }
}
