package ie.cit.cloud.tickets.model.performance;

import java.util.Date;

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
	private Long performerId;

	private Long locationId;

	private Date date;

	private String eventName;

	private Long ticketCount;

	private Long ticketPrice;

	public EventCreator()
	{
	}

	public EventCreator(final Long performerId, final Long locationId, final Date date, final String eventName, final Long ticketCount, final Long ticketPrice)
	{
		this.performerId = performerId;
		this.locationId = locationId;
		this.date = date;
		this.eventName = eventName;
		this.ticketCount = ticketCount;
		this.ticketPrice = ticketPrice;
	}

	public Long getPerformerId()
	{
		return performerId;
	}

	public Long getLocationId()
	{
		return locationId;
	}

	public Date getDate()
	{
		return date;
	}

	public String getEventName()
	{
		return eventName;
	}

	public Long getTicketCount()
	{
		return ticketCount;
	}

	public Long getTicketPrice()
	{
		return ticketPrice;
	}

	public void setPerformerId(Long performerId)
	{
		this.performerId = performerId;
	}

	public void setLocationId(Long locationId)
	{
		this.locationId = locationId;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}

	public void setTicketCount(Long ticketCount)
	{
		this.ticketCount = ticketCount;
	}

	public void setTicketPrice(Long ticketPrice)
	{
		this.ticketPrice = ticketPrice;
	}
}
