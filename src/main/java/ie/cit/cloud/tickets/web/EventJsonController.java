package ie.cit.cloud.tickets.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.cit.cloud.tickets.IEventService;
import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.EventCreator;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;
import ie.cit.cloud.tickets.web.exceptions.WebNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

@Controller
@RequestMapping("api")
public class EventJsonController
{
	@Autowired
	IEventService eventService;

	/* 
	 * try with 
	 * curl http://localhost:8080/tickets/api/performers 
	 * 
	 * */
	@RequestMapping("performers")
	public @ResponseBody List<Performer> getPerformers()
	{
		return eventService.getPerformers();
	}

    /* 
    *
    * try with 
    * curl http://localhost:8080/tickets/api/performer/U2 
    * 
    * */
    @RequestMapping(value = "/performer/{performerName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Performer getPerformer(@PathVariable("performerName") String performerName)
    {
    	final Performer performer = eventService.getPerformer(performerName);
    	if(performer == null)
    	{
    		throw new WebNotFoundException(performerName);
    	}
    	return performer;
    }
	
    /*
     * 
     * try: 
     * curl -i -H "Content-Type: application/json" 
     * 		-X POST -d '{"name":"U2"}' 
     * 		http://localhost:8080/tickets/api/performer
     * 
     */
    @RequestMapping(value = "/performer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerformer(@RequestBody final Performer performer, final HttpServletRequest request, final HttpServletResponse response)
    {
    	eventService.createPerformer(performer);
    	response.addHeader("Performer", getLocationForChildResource(request, performer.getName()));
    }
	
    @RequestMapping(value = "/performer/{performerName}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerformer(@PathVariable("performerName") String performerName)
    {
    	eventService.deletePerformer(performerName);
    }

    
    
	/* 
	 * 
	 * try with 
	 * curl http://localhost:8080/tickets/api/locations 
	 * 
	 * */
	@RequestMapping("locations")
	public @ResponseBody List<Location> getLocations()
	{
		return eventService.getLocations();
	}

	/*
	 * 
	 * try with curl http://localhost:8080/tickets/api/location/Cork
	 * 
	 */
	@RequestMapping(value = "/location/{locationName}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Location getLocation(@PathVariable("locationName") String locationName)
	{
		final Location location = eventService.getLocation(locationName);
		if(location == null)
		{
			throw new WebNotFoundException(locationName);
		}
		return location;
	}

    @RequestMapping(value = "/event/location/{location}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /* 
     * 
     * try with 
     * curl http://localhost:8080/tickets/api/event/location/Cork 
     * 
     * */
    public @ResponseBody List<Event> getEventByLocation(@PathVariable("location") String locationName)
    {
    	final List<Event> event = eventService.getEvents(null, locationName);
    	if(event == null)
    	{
    		throw new WebNotFoundException(locationName);
    	}
    	return event;
    }

	/*
	 * 
	 * try: curl -i -H "Content-Type: application/json" -X POST -d
	 * {"name":"Cork","maxTicketCount":500}
	 * http://localhost:8080/tickets/api/location
	 */
	@RequestMapping(value = "/location", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createLocation(@RequestBody final Location location, final HttpServletRequest request, final HttpServletResponse response)
	{
		eventService.createLocation(location);
		response.addHeader("Location", getLocationForChildResource(request, location.getName()));
	}	
	
	
	
	
	
	
	
	
	
	
	/* 
	 * 
	 * try with
	 * curl http://localhost:8080/tickets/api/events
	 * 
	 *  */
	@RequestMapping("events")
	public @ResponseBody List<Event> getEvents()
	{
		return eventService.getEvents();
	}

	/*
	 * 
	 * try with curl http://localhost:8080/tickets/api/event/performer/U2
	 */
	@RequestMapping(value = "/event/performer/{performer}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Event> getEventByPerformer(@PathVariable("performer") String performerName)
	{
		final List<Event> event = eventService.getEvents(performerName, null);
		if(event == null)
		{
			throw new WebNotFoundException(performerName);
		}
		return event;
	}
	
    /* 
    *
    * try with 
    * curl http://localhost:8080/tickets/api/event/performer/U2/location/Cork 
    * 
    * */
    @RequestMapping(value = "/event/performer/{performer}/location/{location}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Event> getEventByPerformerAndLocation(@PathVariable("performer") String performerName, @PathVariable("location") String locationName)
    {
    	final List<Event> event = eventService.getEvents(performerName, locationName);
    	if(event == null)
    	{
    		throw new WebNotFoundException(locationName);
    	}
    	return event;
    }
	
	
	/*
	 * 
	 * try: curl -i -H "Content-Type: application/json" -X POST -d
	 * '{"performerName":"U2", "locationName":"Cork", "eventName":"U2 Live - Cork", "ticketCount":400 }'
	 * http://localhost:8080/tickets/api/event
	 */
	@RequestMapping(value = "/event", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createEvent(@RequestBody final EventCreator newEvent, final HttpServletRequest request, final HttpServletResponse response)
	{
		final Event event = eventService.createEvent(newEvent.getPerformerName(),
				newEvent.getLocationName(), 
				newEvent.getEventName(), 
				newEvent.getTicketCount());
		response.addHeader("Event", getLocationForChildResource(request, event.getEventName()));
	}	
	
	
	@RequestMapping("bookings")
	public @ResponseBody List<Booking> getBookings()
	{
		return eventService.getBookings();
	}

	
		

    
    
    
    
    private String getLocationForChildResource(final HttpServletRequest request, final Object childIdentifier)
	{
		// get the current URL from the request
		final StringBuffer url = request.getRequestURL();
		// append the /xyz to the URL and make it a UriTemplate
		final UriTemplate template = new UriTemplate(url.append("/{childId}").toString());
		return template.expand(childIdentifier).toASCIIString();
	}
}
