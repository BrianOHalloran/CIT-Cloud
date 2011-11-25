package ie.cit.cloud.tickets.model;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.List;

//import org.hibernate.Query;
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
	public Performer getPerformer(String performerName)
	{
//		final Query query = session().createQuery("from PERFORMER p where p.name = :performerName");
//		query.setParameter("performerName", performerName);
//		final List performerList = query.list();
//		if(performerList != null)
//		{
//			final List<Performer> performers = (List<Performer>)performerList;
//			if(performers.size() == 1)
//			{
//				return performers.iterator().next();
//			}
//		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Performer> getPerformers()
	{
//		return em.createQuery("from PERFORMER").getResultList();
		return (List<Performer>)session().createQuery("from Performer").list();
	}

	@Override
	public Location getLocation(String locationName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocations()
	{
		return null;
//		return em.createQuery("from LOCATION").getResultList();
//		return (List<Location>)session().createQuery("LOCATION").list();
	}

	@Override
	public Event getEvent(Performer performer, Location location)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents()
	{
		return null;
//		return em.createQuery("from EVENT").getResultList();
//		return (List<Event>)session().createQuery("EVENT").list();
	}

	private Session session()
	{
		return sf.getCurrentSession();
	}
}
