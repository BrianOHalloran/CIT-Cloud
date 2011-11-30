package ie.cit.cloud.tickets;

import ie.cit.cloud.tickets.model.IEventRepository;
import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService implements IEventService
{
	@Autowired
	@Qualifier("hibernateEventRepository")
	private IEventRepository eventRepository;

	public EventService()
	{

	}

	@Transactional
	public Location createLocation(final String locationName, final Long maxTicketCount)
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
	
	@Transactional
	public void deletePerformer(final Long performerId)
	{
		eventRepository.deletePerformer(performerId);
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
		Performer performer = null;
		try
		{
			performer = eventRepository.getPerformer(performerName);
		}
		catch(final EmptyResultDataAccessException e)
		{
			throw e;
		}
		
		Location location = null;
		try
		{
			location = eventRepository.getLocation(locationName);
		}
		catch(final EmptyResultDataAccessException e)
		{
			throw e;
		}

		try
		{
			return eventRepository.getEvents(performer, location);
		}
		catch(final EmptyResultDataAccessException e)
		{
			return Collections.emptyList();
		}
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
	public Event createEvent(final Long performerId, 
			final Long locationId, 
			final Date date, 
			final String eventName, 
			final Long ticketCount,
			final Long ticketPrice)
	{
		if(date == null || eventName == null)
		{
			return null;
		}
		
		Performer performer = eventRepository.getPerformer(performerId);
		Location location = eventRepository.getLocation(locationId);
		return createEvent(performer, location, date, eventName, ticketCount, ticketPrice);
	}

	@Transactional
	public Event createEvent(final Performer performer, 
			final Location location, 
			final Date date, 
			final String eventName, 
			final Long ticketCount,
			final Long ticketPrice)
	{
		if(performer == null || location == null || date == null || ticketCount < 0 || ticketPrice < 0)
		{
			return null;
		}
		
		return eventRepository.createEvent(performer, location, date, eventName, ticketCount, ticketPrice);
	}
	
	@Transactional(readOnly = true)
	public List<Booking> getBookings()
	{
		return eventRepository.getCustomerBookings();
	}
}
