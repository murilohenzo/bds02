package com.devsuperior.bds02.services;

import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EventService {
    private EventRepository repository;

    @Autowired
    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event updateEvent(Long id, Event event) {
        Event existEvent = this.findById(id);
        existEvent.setName(event.getName());
        existEvent.setCity(event.getCity());
        existEvent.setUrl(event.getUrl());
        existEvent.setDate(event.getDate());
        return repository.save(existEvent);
    }

    public Event findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found"));
    }
}
