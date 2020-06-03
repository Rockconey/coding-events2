package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("events")
public class EventController {


//    @GetMapping
//    public String displayAllEvents(Model model) {

//        HashMap<String, String> events = new HashMap<>();
//        events.put("Code with Pride", "This affinity group meets bi-monthly in order to offer a safe space for LGBTQIA+ technologists and allies to mingle, network, seek help, build mentor/mentee relationships and work for inclusive change in the St. Louis tech community and beyond.");
//        events.put("Strange Loop", "Strange Loop is a multi-disciplinary conference that brings together the developers and thinkers building tomorrow's technology in fields such as emerging languages, alternative databases, concurrency, distributed systems, security, and the web.");
//        events.put("Apple WWDC", "Apple uses the event to showcase its new software and technologies for software developers. Attendees can participate in hands-on labs with Apple engineers and attend in-depth sessions covering a wide variety of topics.");
//        events.put("SpringOne Platform", "The premier conference for those who build, deploy, and run cloud-native software.");
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }
    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required =false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }









}
