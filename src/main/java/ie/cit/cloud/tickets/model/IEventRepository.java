package ie.cit.cloud.tickets.model;

import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.Date;
import java.util.List;

public interface IEventRepository
{
	Performer getPerformer(final String performerName);
	List<Performer> getPerformers();
	
	Location getLocation(final String locationName);
	List<Location> getLocations();
	
	Event getEvent(final Performer performer, final Location location, final Date date);
	List<Event> getEvents(final Performer performer, final Location location);
	List<Event> getEvents();
}
