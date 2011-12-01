package ie.cit.cloud.tickets;

import ie.cit.cloud.tickets.model.IEventRepository;
import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
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
	public Performer createPerformer(final String name)
	{
		final Performer performer = new Performer(name);
		createPerformer(performer);
		return performer;
	}
	
	@Transactional
	public void createPerformer(final Performer performer)
	{
		try
		{
			eventRepository.createPerformer(performer);
		}
		catch(final ConstraintViolationException e)
		{
			e.printStackTrace();
		}
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
		try
		{
			eventRepository.createLocation(location);
		}
		catch(final ConstraintViolationException e)
		{
			e.printStackTrace();
		}
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
	
	@Transactional(readOnly = true)
	public List<Event> getEvents(final String performerName, final String locationName)
	{
		Performer performer = null;
		if(performerName != null && !performerName.equals(""))
		{
			try
			{
				performer = eventRepository.getPerformer(performerName);
			}
			catch(final EmptyResultDataAccessException e)
			{
				return Collections.emptyList();
			}
		}
		
		Location location = null;
		if(locationName != null && !locationName.equals(""))
		{
			try
			{
				location = eventRepository.getLocation(locationName);
			}
			catch(final EmptyResultDataAccessException e)
			{
				return Collections.emptyList();
			}
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
	public Event getEvent(String performerName, String locationName, Date eventDate)
	{
		final Performer performer = eventRepository.getPerformer(performerName);
		final Location location = eventRepository.getLocation(locationName);
		return eventRepository.getEvent(performer, location);
	}
	
	@Transactional
	public Event createEvent(final String performerName, 
			final String locationName, 
			final String eventName, 
			final Long ticketCount)
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

//	@Transactional
//	public Customer createCustomer(final String name, final String phone, final String ccNum, final String username, final String password)
//	{
//		final Customer customer = new Customer(name, phone, ccNum, username, password);
//		// TODO: populate this
//		return customer;
//	}
	
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
