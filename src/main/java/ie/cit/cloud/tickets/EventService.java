package ie.cit.cloud.tickets;

import ie.cit.cloud.tickets.model.performance.Band;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService
{

	public Location getLocation(final String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Location> getLocations()
	{
		final List<Location> locations = new ArrayList<Location>();

		locations.add(new Location("1", "Cork"));
		locations.add(new Location("2", "Dublin"));
		
		return locations;
	}

	public Performer getPerformer(final String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Performer> getPerformers()
	{
		final List<Performer> performers = new ArrayList<Performer>();

		performers.add(new Band("1", "U2"));
		performers.add(new Band("2", "Christy Moore"));
		performers.add(new Band("3", "Justin Bieber"));

		return performers;
	}

	public Event getEvent(final String performerName, final String locationName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Event> getEventsFor(final String performerName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Event> getEventsAt(final String locationName)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
