package com.devsuperior.bds02.cotrollers;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.mapper.CityMapper;
import com.devsuperior.bds02.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cities")
public class CityController {
    @Autowired
    private CityService service;

    @Autowired
    private CityMapper mapper;

    @GetMapping()
    public ResponseEntity<List<CityDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                service.findAllCities().stream().map(mapper::toDTO).collect(Collectors.toList())
        );
    }

    @PostMapping()
    public ResponseEntity<CityDTO> create(@RequestBody CityDTO cityDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                mapper.toDTO(
                        service.createCity(mapper.toEntity(cityDTO))
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteCity(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
