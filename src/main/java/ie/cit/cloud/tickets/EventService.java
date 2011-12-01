package ie.cit.cloud.tickets;

import ie.cit.cloud.tickets.model.IEventRepository;
import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService implements IEventService
{
	@Qualifier("hibernateEventRepository")
	private IEventRepository eventRepository;

	@Autowired
	public EventService(final IEventRepository eventRepository)
	{
		this.eventRepository = eventRepository;
	}

	@Transactional(readOnly = true)
	public List<Performer> getPerformers()
	{
		final List<Performer> performers = eventRepository.getPerformers();
		if(performers != null)
		{
			return performers;
		}
		return Collections.emptyList();
	}

	@Transactional(readOnly = true)
	public Performer getPerformer(final String name)
	{
		return eventRepository.getPerformer(name);
	}

	@Transactional
	public void createPerformer(final Performer performer)
	{
		eventRepository.createPerformer(performer);
	}
	
	@Transactional
	public void deletePerformer(final String performerName)
	{
		eventRepository.deletePerformer(new Performer(performerName));
	}
	

	
	
	@Transactional(readOnly = true)
	public List<Location> getLocations()
	{

		final List<Location> locations = eventRepository.getLocations();
		if(locations != null)
		{
			return locations;
		}
		return Collections.emptyList();
	}


	@Transactional
	public void createLocation(final Location location)
	{
		eventRepository.createLocation(location);
	}

	@Transactional(readOnly = true)
	public Location getLocation(final String name)
	{
		return eventRepository.getLocation(name);
	}


	
	
	
	
	
	
	@Transactional(readOnly = true)
	public List<Event> getEvents()
	{
		return eventRepository.getEvents();
	}
	
//	@Transactional(readOnly = true)
//	public List<Event> getEvents(final String performerName, final String locationName)
//	{
//		Performer performer = null;
//		if(performerName != null && !performerName.equals(""))
//		{
//			performer = eventRepository.getPerformer(performerName);
//			if(performer == null)
//			{
//				return Collections.emptyList();
//			}
//		}
//		
//		Location location = null;
//		if(locationName != null && !locationName.equals(""))
//		{
//			location = eventRepository.getLocation(locationName);
//			if(location == null)
//			{
//				return Collections.emptyList();
//			}
//		}
//
//		try
//		{
//			return eventRepository.getEvents(performer, location);
//		}
//		catch(final EmptyResultDataAccessException e)
//		{
//			return Collections.emptyList();
//		}
//	}

	@Transactional(readOnly = true)
	public List<Event> getEventsFor(String performerName)
	{
		return eventRepository.getEventsForPerformer(performerName);
	}

	@Transactional(readOnly = true)
	public List<Event> getEventsAt(String locationName)
	{
		return eventRepository.getEventsForLocation(locationName);
	}

	@Transactional(readOnly = true)
	public Event getEvent(final String performerName, final String locationName)
	{
		final Performer performer = eventRepository.getPerformer(performerName);
		final Location location = eventRepository.getLocation(locationName);
		return eventRepository.getEvent(performer, location);
	}
	
	@Transactional
	public Event createEvent(final String performerName, 
			final String locationName, 
			final String eventName, 
			final int ticketCount)
	{
		if(eventName == null)
		{
			return null;
		}
		
		Performer performer = eventRepository.getPerformer(performerName);
		Location location = eventRepository.getLocation(locationName);
		if(performer == null || location == null || ticketCount < 0)
		{
			return null;
		}
		
		return eventRepository.createEvent(performer, location, eventName, ticketCount);
	}

	@Transactional(readOnly = true)
	public List<Booking> getBookings()
	{
		return eventRepository.getCustomerBookings();
	}
	
	@Transactional
	public long createBooking(String performerName, String locationName, int numTickets)
	{
		return eventRepository.createCustomerBooking(performerName, locationName, numTickets);
	}
}
