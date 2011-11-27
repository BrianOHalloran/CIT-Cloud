package ie.cit.cloud.tickets;

import ie.cit.cloud.tickets.model.IEventRepository;
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
import org.springframework.transaction.annotation.Transactional;

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

		performers.add(new Performer("U2"));
		performers.add(new Performer("Christy Moore"));
		performers.add(new Performer("Justin Bieber"));

		// Performer, Location, Date, eventName, ticketCount
		events.add(new Event(performers.get(0), locations.get(0), new Date(), "U2 in Cork", 500, 50));
		events.add(new Event(performers.get(0), locations.get(1), new Date(), "U2 in Dublin", 800, 60));

		events.add(new Event(performers.get(1), locations.get(0), new Date(), "Christy Moore - Live in Cork", 500, 40));

		events.add(new Event(performers.get(2), locations.get(0), new Date(), "Bieber in Cork", 500, 70));
		events.add(new Event(performers.get(2), locations.get(1), new Date(), "Bieber in Dublin", 800, 90));
	}

	@Transactional
	public Location createLocation(final String locationName, final int maxTicketCount)
	{
		return eventRepository.createLocation(locationName, maxTicketCount);
	}
	
	@Transactional(readOnly = true)
	public Location getLocation(final String name)
	{
		return eventRepository.getLocation(name);
	}

	@Transactional(readOnly = true)
	public List<Location> getLocations()
	{

		return eventRepository.getLocations();
	}

	@Transactional
	public Performer createPerformer(final String name)
	{
		return eventRepository.createPerformer(name);
	}
	
	@Transactional(readOnly = true)
	public Performer getPerformer(final String name)
	{
		return eventRepository.getPerformer(name);
	}

	@Transactional(readOnly = true)
	public List<Performer> getPerformers()
	{
		try
		{
			return eventRepository.getPerformers();
		}
		catch(final Exception e)
		{
			// TODO: logging of exceptions
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Transactional(readOnly = true)
	public List<Event> getEvents()
	{
		return eventRepository.getEvents();
	}
	
	@Transactional(readOnly = true)
	public List<Event> getEvents(final String performerName, final String locationName)
	{
		final Performer performer = eventRepository.getPerformer(performerName);
		final Location location = eventRepository.getLocation(locationName);
		final List<Event> events = eventRepository.getEvents(performer, location);
		return events;
		
//		if(performerName == null || locationName == null)
//		{
//			return Collections.emptyList();
//		}
//
//		final List<Event> events = new ArrayList<Event>();
//		if(performerName.equals("ALL_PERFORMERS")) // value from index.jsp
//		{
//			if(locationName.equals("ALL_LOCATIONS")) // value from index.jsp
//			{
//				events.addAll(this.events);
//			}
//			else
//			{
//				for(final Event event : this.events)
//				{
//					if(event.getLocation().getName().equals(locationName))
//					{
//						events.add(event);
//					}
//				}
//			}
//		}
//		else
//		{
//			if(locationName.equals("ALL_LOCATIONS")) // value from index.jsp
//			{
//				for(final Event event : this.events)
//				{
//					if(event.getPerformer().getName().equals(performerName))
//					{
//						events.add(event);
//					}
//				}
//			}
//			else
//			{
//				for(final Event event : this.events)
//				{
//					if(event.getLocation().getName().equals(locationName) && event.getPerformer().getName().equals(performerName))
//					{
//						events.add(event);
//					}
//				}
//			}
//		}
//		return events;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Event> getEventsFor(String performerName)
	{
		return eventRepository.getEventsForPerformer(performerName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Event> getEventsAt(String locationName)
	{
		return eventRepository.getEventsForLocation(locationName);
	}

	@Transactional(readOnly = true)
	public Event getEvent(String performerName, String locationName, Date eventDate)
	{
		final Performer performer = eventRepository.getPerformer(performerName);
		final Location location = eventRepository.getLocation(locationName);
		return eventRepository.getEvent(performer, location, eventDate);
	}
	
	@Transactional
	public Event createEvent(final String performer, 
			final String location, 
			final Date date, 
			final String eventName, 
			final int ticketCount,
			final int ticketPrice)
	{
		if(performer == null || location == null || date == null)
		{
			return null;
		}
		
		return createEvent(eventRepository.getPerformer(performer), eventRepository.getLocation(location), date, eventName, ticketCount, ticketPrice);
	}

	@Transactional
	public Event createEvent(final Performer performer, 
			final Location location, 
			final Date date, 
			final String eventName, 
			final int ticketCount,
			final int ticketPrice)
	{
		if(performer == null || location == null || date == null)
		{
			return null;
		}
		
		return eventRepository.createEvent(performer, location, date, eventName, ticketCount, ticketPrice);
	}
}
