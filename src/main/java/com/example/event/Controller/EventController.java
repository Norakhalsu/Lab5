package com.example.event.Controller;


import com.example.event.Api.ApiRessponse;
import com.example.event.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    List<Event> events = new ArrayList<>();

    @PostMapping("/add") // creat new event
    public Event addEvent(@RequestBody Event event) {
        events.add(event);
        return event;
    }


    @GetMapping("/get") // display all event
    public List<Event> getEvents() {
        return events;
    }

    @PutMapping("/update/{index}") // Update Event
    public ApiRessponse updateEvent(@RequestBody Event updateEvent , @PathVariable int index ) {
         events.set(index , updateEvent);
        return new ApiRessponse(" event Updated");
    }


    @DeleteMapping("/delete/{index}")  // delete Event
    public ApiRessponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiRessponse(" event Deleted");
    }

    @PutMapping("/update/{capacity}/{index}") // change capacity
    public ApiRessponse updateCapacity( @PathVariable int capacity , @PathVariable int index ) {
        events.get(index).setCapacity(capacity);
        return new ApiRessponse(" capacity updated ");
    }


    @GetMapping("/search/{id}") // search for event by given index
    public Event sarchEvent(@PathVariable int id) {
       // return events.get(index);

        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;

    }

}
