package ie.cit.cloud.tickets.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import ie.cit.cloud.tickets.IEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
