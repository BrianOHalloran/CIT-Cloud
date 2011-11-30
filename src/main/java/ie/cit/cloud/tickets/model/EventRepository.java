package ie.cit.cloud.tickets.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.customer.Customer;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Query;

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

	@Override
	public Performer createPerformer(final String name)
	{
		final Performer performer = new Performer(name);
		em.persist(performer);
		return performer;
	}
	
	@Override
	public void deletePerformer(final Long performerId)
	{
		final Performer performer = getPerformer(performerId);
		if(performer == null)
		{
			return;
		}
		
		// TODO: implement the actual delete from the database
		
//		final List<Event> events = getEventsForPerformer(performer.getName());
//		if(events != null && !events.isEmpty())
//		{
//			final SortedSet<Integer> eventIds = new TreeSet<Integer>();
//
//			for(final Event event : events)
//			{
//				eventIds.add(event.getId());
//			}
//			
//			final Query query = em.createQuery("from Booking b where b.event_id in {:eventIds}");
//			query.setParameter("eventIds", eventIds);
//			query.executeUpdate();
//			
//		}
	}
	
	@Override
	public Performer getPerformer(Long performerId)
	{
		final Query query = em.createQuery("from Performer p where p.id = :performerId");
		query.setParameter("performerId", performerId);
		final Object result = query.getSingleResult();
		if(result != null && result instanceof Performer)
		{
			return (Performer)result;
		}
		return null;
	}

	@Override
	public Performer getPerformer(final String performerName)
	{
		final Query query = em.createQuery("from Performer p where p.name = :performerName");
		query.setParameter("performerName", performerName);
		final Object result = query.getSingleResult();
		if(result != null && result instanceof Performer)
		{
			return (Performer)result;
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
	public Location createLocation(final String locationName, final Long ticketCount)
	{
		final Location location = new Location(locationName, ticketCount);
		em.persist(location);
		return location;
	}
 
	@Override
	public Location getLocation(Long locationId)
	{
		final Query query = em.createQuery("from Location l where l.id = :locationId");
		query.setParameter("locationId", locationId);
		final Object result = query.getSingleResult();
		if(result != null && result instanceof Location)
		{
			return (Location)result;
		}
		return null;
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
	@Override
	public List<Location> getLocations()
	{
		return em.createQuery("from Location").getResultList();
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

	@Override
	public Event getEvent(final Performer performer, final Location location, final Date date)
	{
		final Query query = em.createQuery("from Event e where e.location.name = :locationName and e.performer.name = :performerName and e.date = :date");
		query.setParameter("locationName", location.getName());
		query.setParameter("performerName", performer.getName());
		final Object result = query.getSingleResult();
		if(result != null && result instanceof Event)
		{
			return (Event)result;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents(final Performer performer, final Location location)
	{
		Query query = null;
		if(performer != null && location != null)
		{
			query = em.createQuery("from Event e where e.location.id = :locationId and e.performer.id = :performerId");
			query.setParameter("locationId", location.getId());
			query.setParameter("performerId", performer.getId());
			return query.getResultList();
		}
		else if(performer == null && location != null)
		{
			query = em.createQuery("from Event e where e.location.id = :locationId");
			query.setParameter("locationId", location.getId());
			return query.getResultList();
		}
		else if(performer != null && location == null)
		{
			query = em.createQuery("from Event e where e.performer.id = :performerId");
			query.setParameter("performerId", performer.getId());
			return query.getResultList();
		}
		else
		{
			return Collections.emptyList();
		}
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
	
	@Override
	public Event createEvent(final Performer performer, final Location location, final Date date, final String eventName, final Long ticketCount, final Long ticketPrice)
	{
		final Event event = new Event(performer, location, date, eventName, ticketCount, ticketPrice);
		em.persist(event);
		return event;
	}

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
		final Query query = em.createQuery("from Booking b where b.customer.username = :username");
		query.setParameter("username", getCurrentUsername());
		final List<Booking> events = (List<Booking>)query.getResultList();
		if(events != null && !events.isEmpty())
		{
			return (List<Booking>)events;
		}
		return Collections.emptyList();
	}
	
	private String getCurrentUsername()
	{
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
