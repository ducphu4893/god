package com.codegym.god.controller;

import com.codegym.god.model.Thing;
import com.codegym.god.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ThingController {
    @Autowired
    private ThingService thingService;
    @GetMapping("/create-thing")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/thing/create");
        modelAndView.addObject("thing",new Thing());
        return modelAndView;
    }

    @PostMapping("/create-thing")
    public ModelAndView saveThing(@ModelAttribute("thing")Thing thing){
        thingService.save(thing);

        ModelAndView modelAndView = new ModelAndView("/thing/create");
        modelAndView.addObject("thing", new Thing());
        modelAndView.addObject("message", "Create successfully");
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView listThing(){
        List<Thing> things = thingService.findAll();
        ModelAndView modelAndView = new ModelAndView("/thing/list");
        modelAndView.addObject("things",things);
        return modelAndView;
    }
}
