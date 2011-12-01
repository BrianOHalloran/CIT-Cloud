package ie.cit.cloud.tickets.model.performance;

/**
 * this object is a helper object for the REST interface to accommodate the creation of
 * a new Event object.  The Event constructor has the ability to create Events.  This
 * object wraps up the creation using primitive parameters
 * 
 * @author ohallb
 *
 */
public class EventCreator
{
	private String performerName;

	private String locationName;

	private String eventName;

	private Integer ticketCount;

	public EventCreator()
	{
	}

	public EventCreator(final String performerName, final String locationName, final String eventName, final Integer ticketCount)
	{
		this.performerName = performerName;
		this.locationName = locationName;
		this.eventName = eventName;
		this.ticketCount = ticketCount;
	}

	public String getPerformerName()
	{
		return performerName;
	}

	public String getLocationName()
	{
		return locationName;
	}

	public String getEventName()
	{
		return eventName;
	}

	public int getTicketCount()
	{
		return ticketCount;
	}

	public void setPerformerName(String performerName)
	{
		this.performerName = performerName;
	}

	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}

	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}

	public void setTicketCount(int ticketCount)
	{
		this.ticketCount = ticketCount;
	}
}
