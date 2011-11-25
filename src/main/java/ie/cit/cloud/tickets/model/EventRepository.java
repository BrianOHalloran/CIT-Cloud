package ie.cit.cloud.tickets.model;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hibernateEventRepository")
public class EventRepository implements IEventRepository
{

//	 @PersistenceContext
//	 private EntityManager em;

	@Autowired
	private SessionFactory sf;

	public EventRepository()
	{

	}

	@Override
	public Performer getPerformer(final String performerName)
	{
//		final Query query = session().createQuery("from Performer p where p.name = :performerName");
//		query.setString("performerName", performerName);
//		final Object result = query.uniqueResult();
//		if(result != null && result instanceof Performer)
//		{
//			return (Performer)result;
//		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Performer> getPerformers()
	{
		//return em.createQuery("from Performer").getResultList();
		return (List<Performer>)session().createQuery("from Performer").list();
	}

	@Override
	public Location getLocation(final String locationName)
	{
//		final Query query = session().createQuery("from Location l where l.name = :locationName");
//		query.setString("locationName", locationName);
//		final Object result = query.uniqueResult();
//		if(result != null && result instanceof Location)
//		{
//			return (Location)result;
//		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocations()
	{
		return null;
//		return em.createQuery("from Location").getResultList();
//		return (List<Location>)session().createQuery("Location").list();
	}

	@Override
	public Event getEvent(final Performer performer, final Location location, final Date date)
	{
//		final Query query = session().createQuery("from Event e where e.location.name = :locationName and e.performer.name = :performerName" and e.date = :date");
//		query.setString("locationName", location.getName());
//		query.setString("performerName", performer.getName());
//		query.setString("date", date.toString());
//		final Object result = query.uniqueResult();
//		if(result != null && result instanceof Event)
//		{
//			return (Event)result;
//		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents(final Performer performer, final Location location)
	{
//		final Query query = session().createQuery("from Event e where e.location.name = :locationName and e.performer.name = :performerName");
//		query.setString("locationName", location.getName());
//		query.setString("performerName", performer.getName());
//		final Object result = query.list();
//		if(result != null)
//		{
//			return (List<Event>)result;
//		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents()
	{
		return null;
//		return em.createQuery("from Event").getResultList();
//		return (List<Event>)session().createQuery("Event").list();
	}

	private Session session()
	{
		return sf.getCurrentSession();
	}
}
