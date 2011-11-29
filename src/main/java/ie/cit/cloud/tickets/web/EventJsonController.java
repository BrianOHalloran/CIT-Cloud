package ie.cit.cloud.tickets.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.cit.cloud.tickets.IEventService;
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

	@RequestMapping("performers")
	/* 
	 * try with 
	 * curl http://localhost:8080/tickets/api/performers 
	 * 
	 * */
	public @ResponseBody List<Performer> getPerformers()
	{
		return eventService.getPerformers();
	}

    @RequestMapping(value = "/performer/{performerName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /* 
     *
     * try with 
     * curl http://localhost:8080/tickets/api/performer/U2 
     * 
     * */
    public @ResponseBody Performer getPerformer(@PathVariable("performerName") String performerName)
    {
    	final Performer performer = eventService.getPerformer(performerName);
    	if(performer == null)
    	{
    		throw new WebNotFoundException(performerName);
    	}
    	return performer;
    }
	
    @RequestMapping(value = "/performer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    /*
     * 
     * try: 
     * curl -i -H "Content-Type: application/json" 
     * 		-X POST -d '{"name":"U2"}' 
     * 		http://localhost:8080/tickets/api/performer
     * 
     */
    public void createPerformer(@RequestBody final Performer performerName, final HttpServletRequest request, final HttpServletResponse response)
    {
    	final Performer newPerformer = eventService.createPerformer(performerName.getName());
    	response.addHeader("Performer", getLocationForChildResource(request, newPerformer.getName()));
    }
	
    @RequestMapping(value = "/performer/{performerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerformer(@PathVariable("performerId") Integer performerId)
    {
    	eventService.deletePerformer(performerId);
    }

    
    
	@RequestMapping("locations")
	/* 
	 * 
	 * try with 
	 * curl http://localhost:8080/tickets/api/locations 
	 * 
	 * */
	public @ResponseBody List<Location> getLocations()
	{
		return eventService.getLocations();
	}

    @RequestMapping(value = "/location/{locationName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /* 
     * 
     * try with 
     * curl http://localhost:8080/tickets/api/location/Cork 
     * 
     * */
    public @ResponseBody Location getLocation(@PathVariable("locationName") String locationName)
    {
    	final Location location = eventService.getLocation(locationName);
    	if(location == null)
    	{
    		throw new WebNotFoundException(locationName);
    	}
    	return location;
    }
	
    @RequestMapping(value = "/location", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    /*
     * 
     * try: 
     * curl -i -H "Content-Type: application/json" 
     * 		-X POST -d {"name":"Cork","maxTicketCount":"500"} 
     * 		http://localhost:8080/tickets/api/location
     * 
     */
    public void createLocation(@RequestBody final Location location, final HttpServletRequest request, final HttpServletResponse response)
    {
    	// TODO: need to sort out the mapping from JSON to Location object
    	final Location newLocation = eventService.createLocation(location.getName(), location.getMaxTicketCount());
    	response.addHeader("Performer", getLocationForChildResource(request, newLocation.getName()));
    }
	


    
    
	@RequestMapping("events")
	/* 
	 * 
	 * try with
	 * curl http://localhost:8080/tickets/api/events
	 * 
	 *  */
	public @ResponseBody List<Event> getEvents()
	{
		return eventService.getEvents();
	}

    @RequestMapping(value = "/event/performer/{performer}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /* 
     * 
     * try with 
     * curl http://localhost:8080/tickets/api/event/performer/U2 
     * 
     * */
    public @ResponseBody List<Event> getEventByPerformer(@PathVariable("performer") String performerName)
    {
    	final List<Event> event = eventService.getEvents(performerName, null);
    	if(event == null)
    	{
    		throw new WebNotFoundException(performerName);
    	}
    	return event;
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
	
    @RequestMapping(value = "/event/performer/{performer}/location/{location}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /* 
     *
     * try with 
     * curl http://localhost:8080/tickets/api/event/performer/U2/location/Cork 
     * 
     * */
    public @ResponseBody List<Event> getEventByPerformerAndLocation(@PathVariable("performer") String performerName, @PathVariable("location") String locationName)
    {
    	final List<Event> event = eventService.getEvents(performerName, locationName);
    	if(event == null)
    	{
    		throw new WebNotFoundException(locationName);
    	}
    	return event;
    }
	
    @RequestMapping(value = "/event", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    /*
     *
     * try: 
     * curl -i -H "Content-Type: application/json" 
     * 		-X POST -d '{"performer":{"name":"U2"}, "location":{"name":"Cork", "maxTicketCount":500}, "eventName":"U2 in Cork", "date":"1322593942892", "ticketCount":"400", "ticketPrice":"120" }' 
     * 		http://localhost:8080/tickets/api/event
     */
    public void createEvent(@RequestBody final Event newEvent, final HttpServletRequest request, final HttpServletResponse response)
    {
    	// TODO: need to sort out the mapping from JSON to Location object
    	final Event event = eventService.createEvent(newEvent.getPerformer(), newEvent.getLocation(), newEvent.getDate(), newEvent.getEventName(), newEvent.getTicketCount(), newEvent.getTicketPrice());
    	response.addHeader("Event", getLocationForChildResource(request, event.getEventName()));
    }
//    public void createEvent(@RequestBody final EventCreator newEvent, final HttpServletRequest request, final HttpServletResponse response)
//    {
//    	// TODO: need to sort out the mapping from JSON to Location object
//    	final Event event = eventService.createEvent(newEvent.getPerformerId(), newEvent.getLocationId(), newEvent.getDate(), newEvent.getEventName(), newEvent.getTicketCount(), newEvent.getTicketPrice());
//    	response.addHeader("Event", getLocationForChildResource(request, event.getEventName()));
//    }

    
    
    
    
    private String getLocationForChildResource(final HttpServletRequest request, final Object childIdentifier)
	{
		// get the current URL from the request
		final StringBuffer url = request.getRequestURL();
		// append the /xyz to the URL and make it a UriTemplate
		final UriTemplate template = new UriTemplate(url.append("/{childId}").toString());
		return template.expand(childIdentifier).toASCIIString();
	}
}
