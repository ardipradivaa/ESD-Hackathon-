package com.domain.ecomeal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.ecomeal.models.entities.Event;
import com.domain.ecomeal.repos.EventRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public Event save(Event event) {
        return eventRepo.save(event);
    }

    public Event findOne(long id){
        return eventRepo.findById(id).get();
    }

    public Iterable<Event> findAll(){
        return eventRepo.findAll();
    }

    public void removeOne(long id){
        eventRepo.deleteById(id);
    }
}
