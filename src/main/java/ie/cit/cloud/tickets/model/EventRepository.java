package ie.cit.cloud.tickets.model;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly = true)
	public Performer getPerformer(String performerName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Performer> getPerformers()
	{
//		return em.createQuery("from PERFORMER").getResultList();
		return session().createQuery("from PERFORMER").list();
	}

	@Override
	@Transactional(readOnly = true)
	public Location getLocation(String locationName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Location> getLocations()
	{
//		return em.createQuery("from LOCATION").getResultList();
		return session().createQuery("LOCATION").list();
	}

	@Override
	@Transactional(readOnly = true)
	public Event getEvent(Performer performer, Location location)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Event> getEvents()
	{
//		return em.createQuery("from EVENT").getResultList();
		return session().createQuery("EVENT").list();
	}

	private Session session()
	{
		return sf.getCurrentSession();
	}
}
