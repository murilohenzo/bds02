package com.devsuperior.bds02.cotrollers;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.mapper.EventMapper;
import com.devsuperior.bds02.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService service;

    @Autowired
    private EventMapper mapper;

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable("id") Long id, @RequestBody EventDTO eventDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                mapper.toDTO(service.updateEvent(id, mapper.toEntity(eventDTO)))
        );
    }
}
