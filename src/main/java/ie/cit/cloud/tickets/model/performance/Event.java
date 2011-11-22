package ie.cit.cloud.tickets.model.performance;

import java.util.Date;
import java.util.UUID;

public class Event
{
	private String id;

	private Performer performer;
	private Location location;
	private Date date;
	private String eventName;

	public Event(final Performer performer, final Location location, final Date date, final String eventName)
	{
		this(UUID.randomUUID().toString(), performer, location, date, eventName);
	}
	
	private Event(final String id, final Performer performer, final Location location, final Date date, final String eventName)
	{
		this.id = id;
		this.performer = performer;
		this.location = location;
		this.date = date;
		this.eventName = eventName;
	}
	
	public final String getId()
	{
		return id;
	}
	public final void setId(final String id)
	{
		this.id = id;
	}
	public final Performer getPerformer()
	{
		return performer;
	}
	public final void setPerformer(final Performer performer)
	{
		this.performer = performer;
	}
	public final Location getLocation()
	{
		return location;
	}
	public final void setLocation(final Location location)
	{
		this.location = location;
	}
	public final Date getDate()
	{
		return date;
	}
	public final void setDate(final Date date)
	{
		this.date = date;
	}
	public final String getEventName()
	{
		return eventName;
	}
	public final void setEventName(final String eventName)
	{
		this.eventName = eventName;
	}
}
