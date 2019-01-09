package com.codegym.god.service.impl;

import com.codegym.god.model.Thing;
import com.codegym.god.repository.ThingRepository;
import com.codegym.god.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ThingServiceImpl implements ThingService {

    @Autowired
    private ThingRepository thingRepository;

    @Override
    public List<Thing> findAll(){
        return thingRepository.findAll();
    }

    @Override
    public Thing findById(Long id){
        return thingRepository.findById(id);
    }

    @Override
    public void save(Thing thing){
        thingRepository.save(thing);
    }

    @Override
    public void remove(Long id){
        thingRepository.remove(id);
    }
}
