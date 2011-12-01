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
	private String performerName;

	private String locationName;

//	private Date date;

	private String eventName;

	private Long ticketCount;

//	private Long ticketPrice;

	public EventCreator()
	{
	}

//	public EventCreator(final String performerName, final String locationName, final Date date, final String eventName, final Long ticketCount, final Long ticketPrice)
	public EventCreator(final String performerName, final String locationName, final String eventName, final Long ticketCount)
	{
		this.performerName = performerName;
		this.locationName = locationName;
//		this.date = date;
		this.eventName = eventName;
		this.ticketCount = ticketCount;
//		this.ticketPrice = ticketPrice;
	}

	public String getPerformerName()
	{
		return performerName;
	}

	public String getLocationName()
	{
		return locationName;
	}

//	public Date getDate()
//	{
//		return date;
//	}

	public String getEventName()
	{
		return eventName;
	}

	public Long getTicketCount()
	{
		return ticketCount;
	}

//	public Long getTicketPrice()
//	{
//		return ticketPrice;
//	}

	public void setPerformerName(String performerName)
	{
		this.performerName = performerName;
	}

	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}

//	public void setDate(Date date)
//	{
//		this.date = date;
//	}

	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}

	public void setTicketCount(Long ticketCount)
	{
		this.ticketCount = ticketCount;
	}

//	public void setTicketPrice(Long ticketPrice)
//	{
//		this.ticketPrice = ticketPrice;
//	}
}
