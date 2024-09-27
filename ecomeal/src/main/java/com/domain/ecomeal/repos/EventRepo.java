package com.domain.ecomeal.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.domain.ecomeal.models.entities.Event;

public interface EventRepo extends CrudRepository<Event, Long> {

    List<Event> findByNameContains(String name);
    
}