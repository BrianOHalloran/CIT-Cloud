package ie.cit.cloud.tickets.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import ie.cit.cloud.tickets.IEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController
{
	@Autowired
	IEventService eventService;

    @RequestMapping(value = { "index", "" }, method = GET)
    public String index(Model model) 
    {
    	model.addAttribute("performers", eventService.getPerformers());
    	model.addAttribute("locations", eventService.getLocations());
    	return "index";
    }

    @RequestMapping(value = { "doSearch", "" }, method = GET)
    public String eventLookup(@RequestParam(value="performerSelection") String performer, @RequestParam(value="locationSelection") String location, Model model) 
    {
    	model.addAttribute("events", eventService.getEvents(performer, location));
    	model.addAttribute("performers", eventService.getPerformers());
    	model.addAttribute("locations", eventService.getLocations());
    	return "search";
    }
}
