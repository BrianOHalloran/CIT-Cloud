package ie.cit.cloud.tickets.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

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
}
