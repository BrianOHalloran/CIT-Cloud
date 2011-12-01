package ie.cit.cloud.tickets.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.customer.Customer;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
		try
		{
			em.persist(performer);
		}
		catch(final ConstraintViolationException e)
		{
			// TODO local logging needed
			e.printStackTrace();
		}
	}
	
	@Override
	public void deletePerformer(final Performer performer)
	{
//		final Performer performer = getPerformer(performerId);
//		if(performer == null)
//		{
//			return;
//		}
//		
//		// TODO: implement the actual delete from the database
//		
//		List<Event> events = null;
//		try
//		{
//			events = getEventsForPerformer(performer.getName());
//		}
//		catch(EmptyResultDataAccessException e)
//		{
//			
//		}
//		if(events != null && !events.isEmpty())
//		{
//			final List<Long> eventIds = new ArrayList<Long>();
//
//			for(final Event event : events)
//			{
//				eventIds.add(event.getId());
//			}
//			
//			try
//			{
//				final Query query = em.createQuery("delete from Booking b where b.event_id in (:eventIds)");
//				query.setParameter("eventIds", eventIds); //.toArray(new Long[eventIds.size()]));
//				query.executeUpdate();
//			}
//			catch(Exception e)
//			{
//				
//			}
//			try
//			{
//				final Query query = em.createQuery("delete from Event e where e.id in (:eventIds)");
//				query.setParameter("eventIds", eventIds); //.toArray(new Long[eventIds.size()]));
//				query.executeUpdate();
//			}
//			catch(Exception e)
//			{
//				
//			}
//		}
//		try
//		{
//			final Query query = em.createQuery("delete from Performer p where p.id = :performerId");
//			query.setParameter("performerId", performerId); //.toArray(new Long[eventIds.size()]));
//			query.executeUpdate();
//		}
//		catch(Exception e)
//		{
//			
//		}
	}
	
	@Override
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
	@Override
	public List<Performer> getPerformers()
	{
		return em.createQuery("from Performer").getResultList();
	}

	
	
	
	
	@Override
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
	
	@Override
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
	@Override
	public List<Event> getEvents()
	{
		final List<Event> events = em.createQuery("from Event").getResultList();
		if(events != null && !events.isEmpty())
		{
			return (List<Event>)events;
		}
		return Collections.emptyList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents(final Performer performer, final Location location)
	{
		Query query = null;
		if(performer != null && location != null)
		{
			query = em.createQuery("from Event e where e.location.name = :locationName and e.performer.name = :performerName");
			query.setParameter("locationName", location.getName());
			query.setParameter("performerName", performer.getName());
			return query.getResultList();
		}
		else if(performer == null && location != null)
		{
			query = em.createQuery("from Event e where e.location.name = :locationName");
			query.setParameter("locationName", location.getName());
			return query.getResultList();
		}
		else if(performer != null && location == null)
		{
			query = em.createQuery("from Event e where e.performer.id = :performerName");
			query.setParameter("performerName", performer.getName());
			return query.getResultList();
		}
		else
		{
			return Collections.emptyList();
		}
	}

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
	
	@Override
	public Event createEvent(final Performer performer, final Location location, final String eventName, final Long ticketCount)
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

	@Override
	public Customer createCustomer(final String name, final String phoneNumber, final String creditCard, final String username, final String password)
	{
		final Customer customer = new Customer(name, phoneNumber, creditCard, username, password);
		em.persist(customer);
		return customer;
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
		Performer performer = getPerformer(performerName);
		Location location = getLocation(locationName);
		Event event = getEvent(performer, location);
		final Booking booking = new Booking(getCurrentUsername(), event, ticketCount);
		em.persist(booking);
		return booking.getId();
	}
	
	private String getCurrentUsername()
	{
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
