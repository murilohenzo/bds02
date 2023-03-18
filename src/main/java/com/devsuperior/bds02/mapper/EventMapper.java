package com.devsuperior.bds02.mapper;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDTO toDTO(Event event) {
        return new EventDTO(event);
    }

    public Event toEntity(EventDTO eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setUrl(eventDTO.getUrl());
        event.setDate(eventDTO.getDate());
        event.setCity(new City(eventDTO.getCityId(), null));

        return event;
    }
}
