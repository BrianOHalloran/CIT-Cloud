package ie.cit.cloud.tickets.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import ie.cit.cloud.tickets.IEventService;
import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.customer.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EventWebController
{
	IEventService eventService;

	@Autowired
	public EventWebController(IEventService eventService)
	{
		this.eventService = eventService;
	}
	
    @RequestMapping(value = { "index", "" }, method = GET)
    public String index(Model model) 
    {
    	model.addAttribute("performers", eventService.getPerformers());
    	model.addAttribute("locations", eventService.getLocations());
    	model.addAttribute("events", eventService.getEvents());

    	// anonymousUser
    	String user = "anonymousUser";
    	try
    	{
    		user = SecurityContextHolder.getContext().getAuthentication().getName();
        	model.addAttribute("loggedIn", user);
    	}
    	catch(final NullPointerException e)
    	{
    		model.addAttribute("loggedIn", user);
    	}
    	return "index";
    }

    @RequestMapping(value = "createCustomer", method = GET)
    public String createCustomerPage(Model model)
    {
    	return "newCustomer";
    }
    
    @RequestMapping(value = "customerCreateDetails", method = POST)
    public String customerDetailsEntry(@RequestParam(value="customerName") String customerName,
    		@RequestParam(value="customerPhone") String customerPhone, 
    		@RequestParam(value="customerCreditCard") String customerCreditCard,
    		@RequestParam(value="customerUsername") String customerUsername,
    		@RequestParam(value="customerPassword") String customerPassword)
    {
    	final Customer curtomer = new Customer(customerName, customerPhone, customerCreditCard, customerUsername, customerPassword);
    	eventService.createCustomer(curtomer);
    	return "redirect:index.html";
    }

    @RequestMapping(value = "secure/account", method = GET)
    public String bookingLookup(Model model)
    {
    	model.addAttribute("bookings", eventService.getBookings());
    	model.addAttribute("customerName", "test_customer_name");
    	model.addAttribute("customerPhone", "test_customer_phone");
    	model.addAttribute("customerCreditCard", "test_customer_card");
    	return "account";
    }
    
    @RequestMapping(value = "secure/account", method = POST)
    public String bookEvent(@RequestParam(value="performerName") String performerName, @RequestParam(value="locationName") String locationName, @RequestParam(value="ticketCountSelection") Integer ticketCount, Model model)
    {
    	final long bookingId = eventService.createBooking(performerName, locationName, ticketCount);
    	model.addAttribute("bookingId", bookingId);
    	model.addAttribute("bookings", eventService.getBookings());
    	return "account";
    }
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String emptyResult(final EmptyResultDataAccessException e)
    {
    	// no code needed
    	return "redirect:../index";
    }
}
