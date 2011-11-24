package ie.cit.cloud.tickets;

import ie.cit.cloud.tickets.model.IEventRepository;
import ie.cit.cloud.tickets.model.performance.Band;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService
{
	@Autowired
	@Qualifier("hibernateEventRepository")
	private IEventRepository eventRepository;

	final List<Location> locations = new ArrayList<Location>();

	final List<Performer> performers = new ArrayList<Performer>();

	final List<Event> events = new ArrayList<Event>();

	public EventService()
	{
		locations.add(new Location("Cork", 500));
		locations.add(new Location("Dublin", 800));
		
		performers.add(new Band("U2"));
		performers.add(new Band("Christy Moore"));
		performers.add(new Band("Justin Bieber"));
		
		// Performer, Location, Date, eventName, ticketCount
//		events.add(new Event(performers.get(0), locations.get(0), new Date(), "U2 in Cork", 500));
//		events.add(new Event(performers.get(0), locations.get(1), new Date(), "U2 in Dublin", 800));
//		
//		events.add(new Event(performers.get(1), locations.get(0), new Date(), "Christy Moore - Live in Cork", 500));
//
//		events.add(new Event(performers.get(2), locations.get(0), new Date(), "Bieber in Cork", 500));
//		events.add(new Event(performers.get(2), locations.get(1), new Date(), "Bieber in Dublin", 800));
	}
	
	public Location getLocation(final String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Location> getLocations()
	{

		return locations;
	}

	public Performer getPerformer(final String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Performer> getPerformers()
	{
		return eventRepository.getPerformers();
	}

	public List<Event> getEvents(final String performerName, final String locationName)
	{
		if(performerName == null || locationName == null)
		{
			return Collections.emptyList();
		}
		
		final List<Event> events = new ArrayList<Event>();
		if(performerName.equals("ALL_PERFORMERS"))	// value from index.jsp
		{
			if(locationName.equals("ALL_LOCATIONS"))	// value from index.jsp
			{
				events.addAll(this.events);
			}
			else
			{
				for(final Event event : this.events)
				{
					if(event.getLocation().getName().equals(locationName))
					{
						events.add(event);
					}
				}
			}
		}
		else
		{
			if(locationName.equals("ALL_LOCATIONS"))	// value from index.jsp
			{
				for(final Event event : this.events)
				{
					if(event.getPerformer().getName().equals(performerName))
					{
						events.add(event);
					}
				}
			}
			else
			{
				for(final Event event : this.events)
				{
					if(event.getLocation().getName().equals(locationName) && event.getPerformer().getName().equals(performerName))
					{
						events.add(event);
					}
				}
			}
		}
		return events;
	}
/*
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
*/
}
