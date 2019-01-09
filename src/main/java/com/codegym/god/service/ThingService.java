package com.codegym.god.service;

import com.codegym.god.model.Thing;

import java.util.List;

public interface ThingService {
    List<Thing> findAll();
    Thing findById(Long id);
    void save (Thing thing);
    void remove(Long id);
}
