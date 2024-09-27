package com.domain.ecomeal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.ecomeal.services.EventService;
import com.domain.ecomeal.models.entities.Event;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/event")
public class EventController {
    
    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public Event create(@RequestBody Event Event) {
        return eventService.save(Event);
    }

    @GetMapping("/{id}")
    public Event findOne(@PathVariable long id){
        return eventService.findOne(id);
    }
    
    @GetMapping("/all")
    public Iterable<Event> findAll(){
        return eventService.findAll();
    }

    @PutMapping("/update")
    public Event update(@RequestBody Event event){
        return eventService.save(event);
    }
    
    @DeleteMapping("/delete/{id}")
    public void removeOne(@PathVariable("id") long id){
        eventService.removeOne(id);
    }
}
