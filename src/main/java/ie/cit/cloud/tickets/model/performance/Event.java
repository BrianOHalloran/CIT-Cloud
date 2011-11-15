package ie.cit.cloud.tickets.model.performance;

import java.util.Date;

public class Event
{
	private String id;

	private Performer performer;
	private Location location;
	private Date date;
	private String eventName;
	
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
