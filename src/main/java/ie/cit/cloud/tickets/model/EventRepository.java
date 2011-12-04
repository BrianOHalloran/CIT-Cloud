package ie.cit.cloud.tickets.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.customer.Customer;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository("hibernateEventRepository")
public class EventRepository implements IEventRepository
{
	@PersistenceContext
	private EntityManager em;

	public EventRepository()
	{

	}

	public void createPerformer(final Performer performer)
	{
		em.persist(performer);
	}
	
	public int deletePerformer(final String performerName)
	{
		int numDeletedEntities = 0;

		Query query = em.createQuery("from Booking b where b.event.performer.name = :performerName");
		query.setParameter("performerName", performerName);
		final List<Booking> bookings = (List<Booking>)query.getResultList();
		
		if(bookings != null && !bookings.isEmpty())
		{
			query = em.createQuery("delete from Booking b where b.event.performer.name = :performerName");
			query.setParameter("performerName", performerName);
			numDeletedEntities += query.executeUpdate();
		}

		query = em.createQuery("delete from Event e where e.performer.name = :performerName");
		query.setParameter("performerName", performerName);
		numDeletedEntities += query.executeUpdate();

		query = em.createQuery("delete from Performer p where p.name = :performerName");
		query.setParameter("performerName", performerName);
		numDeletedEntities += query.executeUpdate();
		
		return numDeletedEntities;
	}
	
	public Performer getPerformer(final String performerName)
	{
		try
		{
			final Query query = em.createQuery("from Performer p where p.name = :performerName");
			query.setParameter("performerName", performerName);
			final Object result = query.getSingleResult();
			if(result != null && result instanceof Performer)
			{
				return (Performer)result;
			}
		}
		catch(final EmptyResultDataAccessException e)
		{
			// TODO: internal logging needed for catching this
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Performer> getPerformers()
	{
		return em.createQuery("from Performer").getResultList();
	}

	
	
	
	
	public void createLocation(final Location location)
	{
		try
		{
			em.persist(location);
		}
		catch(final ConstraintViolationException e)
		{
			// TODO local logging needed
			e.printStackTrace();
		}
	}
	
	public Location getLocation(final String locationName)
	{
		final Query query = em.createQuery("from Location l where l.name = :locationName");
		query.setParameter("locationName", locationName);
		final Object result = query.getSingleResult();
		if(result != null && result instanceof Location)
		{
			return (Location)result;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Location> getLocations()
	{
		return em.createQuery("from Location").getResultList();
	}



	
	@SuppressWarnings("unchecked")
	public List<Event> getEvents()
	{
		final List<Event> events = em.createQuery("from Event").getResultList();
		if(events != null && !events.isEmpty())
		{
			return (List<Event>)events;
		}
		return Collections.emptyList();
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Event> getEvents(final Performer performer, final Location location)
//	{
//		Query query = null;
//		if(performer != null && location != null)
//		{
//			query = em.createQuery("from Event e where e.location.name = :locationName and e.performer.name = :performerName");
//			query.setParameter("locationName", location.getName());
//			query.setParameter("performerName", performer.getName());
//			return query.getResultList();
//		}
//		else if(performer == null && location != null)
//		{
//			query = em.createQuery("from Event e where e.location.name = :locationName");
//			query.setParameter("locationName", location.getName());
//			return query.getResultList();
//		}
//		else if(performer != null && location == null)
//		{
//			query = em.createQuery("from Event e where e.performer.id = :performerName");
//			query.setParameter("performerName", performer.getName());
//			return query.getResultList();
//		}
//		else
//		{
//			return Collections.emptyList();
//		}
//	}

	public Event getEvent(final Performer performer, final Location location)
	{
		Query query = null;
		if(performer != null && location != null)
		{
			query = em.createQuery("from Event e where e.location.name = :locationName and e.performer.name = :performerName");
			query.setParameter("locationName", location.getName());
			query.setParameter("performerName", performer.getName());
			return (Event)query.getSingleResult();
		}
		else if(performer == null && location != null)
		{
			query = em.createQuery("from Event e where e.location.name = :locationName");
			query.setParameter("locationName", location.getName());
			return (Event)query.getSingleResult();
		}
		else if(performer != null && location == null)
		{
			query = em.createQuery("from Event e where e.performer.id = :performerName");
			query.setParameter("performerName", performer.getName());
			return (Event)query.getSingleResult();
		}
		else
		{
			return null;
		}
	}
	
	public Event createEvent(final Performer performer, final Location location, final String eventName, final int ticketCount)
	{
		try
		{
			Event event = getEvent(performer, location);
			event.setEventName(eventName);
			event.setTicketCount(ticketCount);
			return event;
		}
		catch (Exception e)
		{
			final Event event = new Event(performer, location, eventName, ticketCount);
			em.persist(event);
			return event;
		}
	}

	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Event> getEventsForPerformer(final String performerName)
	{
		final Query query = em.createQuery("from Event e where e.performer.name = :performerName");
		query.setParameter("performerName", performerName);
		final List<Event> events = (List<Event>)query.getResultList();
		if(events != null && !events.isEmpty())
		{
			return (List<Event>)events;
		}
		return Collections.emptyList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getEventsForLocation(final String locationName)
	{
		final Query query = em.createQuery("from Event e where e.location.name = :locationName");
		query.setParameter("locationName", locationName);
		final List<Event> events = (List<Event>)query.getResultList();
		if(events != null && !events.isEmpty())
		{
			return (List<Event>)events;
		}
		return Collections.emptyList();
	}

//	@Override
//	public Event getEvent(final Performer performer, final Location location, final Date date)
//	{
//		final Query query = em.createQuery("from Event e where e.location.name = :locationName and e.performer.name = :performerName and e.date = :date");
//		query.setParameter("locationName", location.getName());
//		query.setParameter("performerName", performer.getName());
//		final Object result = query.getSingleResult();
//		if(result != null && result instanceof Event)
//		{
//			return (Event)result;
//		}
//		return null;
//	}

	public void createCustomer(final Customer customer)
	{
		em.persist(customer);
	}
	
	@SuppressWarnings("unchecked")
	public List<Booking> getCustomerBookings()
	{
		final Query query = em.createQuery("from Booking b where b.user = :username");
		query.setParameter("username", getCurrentUsername());
		final List<Booking> events = (List<Booking>)query.getResultList();
		if(events != null && !events.isEmpty())
		{
			return (List<Booking>)events;
		}
		return Collections.emptyList();
	}
	
	public long createCustomerBooking(final String performerName, final String locationName, final int ticketCount)
	{
		try
		{
			Performer performer = getPerformer(performerName);
			Location location = getLocation(locationName);
			Event event = getEvent(performer, location);
			final Booking booking = new Booking(getCurrentUsername(), event, ticketCount);
			em.persist(booking);
			event.setTicketCount(event.getTicketCount() - ticketCount);
			return booking.getId();
		}
		catch(EmptyResultDataAccessException e)
		{
			
		}
		
		return Booking.INVALID_BOOKING_ID;
	}
	
	private String getCurrentUsername()
	{
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
