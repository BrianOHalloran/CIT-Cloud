package ie.cit.cloud.tickets;

import java.util.List;

import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

public interface IEventService
{
	Location getLocation(final String name);
	List<Location> getLocations();
	
	Performer getPerformer(final String name);
	List<Performer> getPerformers();

	Event getEvent(final String performerName, final String locationName);
}
