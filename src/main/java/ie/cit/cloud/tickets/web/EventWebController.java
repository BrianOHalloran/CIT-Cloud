package ie.cit.cloud.tickets.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
//import static org.springframework.web.bind.annotation.RequestMethod.POST;

import ie.cit.cloud.tickets.IEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventWebController
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

    @RequestMapping(value = { "bookEvent" }, method = GET)
    public String bookEvent(Model model)
    {
    	return "accounts/account";
    }

    @RequestMapping(value = { "showAccountData" }, method = GET)
    public String bookingLookup(Model model)
    {
    	model.addAttribute("bookings", eventService.getBookings());
    	model.addAttribute("customerName", "test_customer_name");
    	model.addAttribute("customerPhone", "test_customer_phone");
    	model.addAttribute("customerCreditCard", "test_customer_card");
    	return "accounts/account";
    }
}
