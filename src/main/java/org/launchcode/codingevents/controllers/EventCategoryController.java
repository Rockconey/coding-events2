package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    @GetMapping("/create")
    public String renderCreateEventCategoryForm(Model model, @ModelAttribute EventCategory newEventCategory) {
        model.addAttribute("title", "Create Category");
        model.addAttribute("EventCategory", newEventCategory);
        return "eventCategories/create";
    }

    @PostMapping
    public String processCreateEventCategoryForm(Model model, @ModelAttribute @Valid EventCategory newEventCategory, Errors errors) {
        model.addAttribute("title", "Create Category");
        model.addAttribute("EventCategory", "newEventCategory");

        if(errors.hasErrors()) {

            return "eventCategories/create";
        }

        return "redirect:";

    }
}
