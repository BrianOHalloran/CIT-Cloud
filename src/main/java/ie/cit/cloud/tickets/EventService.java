package ie.cit.cloud.tickets;

import ie.cit.cloud.tickets.model.IEventRepository;
import ie.cit.cloud.tickets.model.performance.Band;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService
{
/*	
	@Autowired
	@Qualifier("hibernateEventRepository")
	private IEventRepository eventRepository;
*/
	public Location getLocation(final String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Location> getLocations()
	{
		final List<Location> locations = new ArrayList<Location>();

		locations.add(new Location("Cork", 500));
		locations.add(new Location("Dublin", 800));
		
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

		performers.add(new Band("U2"));
		performers.add(new Band("Christy Moore"));
		performers.add(new Band("Justin Bieber"));

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
