package ie.cit.cloud.tickets.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ie.cit.cloud.tickets.model.customer.Customer;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

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

	public Location createLocation(final String locationName, final int ticketCount)
	{
		final Location location = new Location(locationName, ticketCount);
		em.persist(location);
		return location;
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
		final Query query = em.createQuery("from Event e where e.location.name = :locationName and e.performer.name = :performerName");
		query.setParameter("locationName", location.getName());
		query.setParameter("performerName", performer.getName());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents()
	{
		return em.createQuery("from Event").getResultList();
	}
	
	public Event createEvent(final Performer performer, 
			final Location location, 
			final Date date, 
			final String eventName, 
			final int ticketCount,
			final int ticketPrice)
	{
		final Event event = new Event(performer, location, date, eventName, ticketCount, ticketPrice);
		em.persist(event);
		return event;
	}

	public Customer createCustomer(final String name, 
			final String phoneNumber, 
			final String creditCard, 
			final String username, 
			final String password)
	{
		final Customer customer = new Customer(name, phoneNumber, creditCard, username, password);
		em.persist(customer);
		return customer;
	}
}
