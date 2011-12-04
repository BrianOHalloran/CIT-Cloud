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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	/**
	 * the testing of this controller was done using the REST plugin for the Chrome browser as
	 * opposed to using the curl cli.
	 */
	IEventService eventService;

	@Autowired
	public EventJsonController(IEventService eventService)
	{
		this.eventService = eventService;
	}
	
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
    	return eventService.getPerformer(performerName);
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
    	response.addHeader("performer", getLocationForChildResource(request, performer.getName()));
    }

    /*
     * 
     * try: 
     * curl -i -H "Content-Type: application/json" 
     * 		-X DELETE http://localhost:8080/tickets/api/performer/Pink
     * 
     */
    @RequestMapping(value = "/performer/{performerName}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerformer(@PathVariable("performerName") String performerName)
    {
    	final int numDeletedEntities = eventService.deletePerformer(performerName);
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
		return eventService.getLocation(locationName);

	}

    @RequestMapping(value = "/event/location/{location}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /* 
     * 
     * try with 
     * curl http://localhost:8080/tickets/api/event/location/Cork 
     * 
     * */
    public @ResponseBody Event getEventByLocation(@PathVariable("location") String locationName)
    {
    	return eventService.getEvent(null, locationName);
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
		response.addHeader("location", getLocationForChildResource(request, location.getName()));
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
	public @ResponseBody Event getEventByPerformer(@PathVariable("performer") String performerName)
	{
		return eventService.getEvent(performerName, null);
	}
	
    /* 
    *
    * try with 
    * curl http://localhost:8080/tickets/api/event/performer/U2/location/Cork 
    * 
    * */
    @RequestMapping(value = "/event/performer/{performer}/location/{location}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Event getEventByPerformerAndLocation(@PathVariable("performer") String performerName, @PathVariable("location") String locationName)
    {
    	return eventService.getEvent(performerName, locationName);
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
		response.addHeader("event", getLocationForChildResource(request, event.getEventName()));
	}	
	
	
	@RequestMapping("bookings")
	public @ResponseBody List<Booking> getBookings()
	{
		return eventService.getBookings();
	}


	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void conflict(final DataIntegrityViolationException e, final HttpServletRequest request, final HttpServletResponse response)
	{
		response.addHeader("exception", e.getMessage());
	}


	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public void notFound(final EmptyResultDataAccessException e, final HttpServletRequest request, final HttpServletResponse response)
	{
		response.addHeader("exception", e.getMessage());
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
