package ie.cit.cloud.tickets.model;

import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventRepositoryStub implements IEventRepository
{
	final List<Location> locations = new ArrayList<Location>();

	final List<Performer> performers = new ArrayList<Performer>();

	final List<Event> events = new ArrayList<Event>();

	public EventRepositoryStub()
	{
		locations.add(new Location("Cork", 500));
		locations.add(new Location("Dublin", 800));
		
		performers.add(new Performer("U2"));
		performers.add(new Performer("Christy Moore"));
		performers.add(new Performer("Justin Bieber"));
		
		// Performer, Location, Date, eventName, ticketCount
		events.add(new Event(performers.get(0), locations.get(0), new Date(), "U2 in Cork", 500, 50));
		events.add(new Event(performers.get(0), locations.get(1), new Date(), "U2 in Dublin", 800, 50));
		
		events.add(new Event(performers.get(1), locations.get(0), new Date(), "Christy Moore - Live in Cork", 500, 40));

		events.add(new Event(performers.get(2), locations.get(0), new Date(), "Bieber in Cork", 500, 60));
		events.add(new Event(performers.get(2), locations.get(1), new Date(), "Bieber in Dublin", 800, 60));
	}

	@Override
	public Performer getPerformer(String performerName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Performer> getPerformers()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getLocation(String locationName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocations()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event getEvent(Performer performer, Location location, Date date)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents(Performer performer, Location location)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
