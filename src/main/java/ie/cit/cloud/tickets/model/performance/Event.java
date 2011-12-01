package ie.cit.cloud.tickets.model.performance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Event
{
	@Id
	private String eventName;

	@NotNull
	@OneToOne
	private Performer performer;

	@NotNull
	@OneToOne
	private Location location;

	@Min(value = 1)
	private Integer ticketCount;

	public Event()
	{

	}

	public Event(final Performer performer, 
			final Location location, 
			final String eventName, 
			final Integer ticketCount)
	{
		this.performer = performer;
		this.location = location;
//		this.date = date;
		this.eventName = eventName;
		if(ticketCount > location.getMaxTicketCount())
		{
			this.ticketCount = location.getMaxTicketCount();
		}
		else
		{
			this.ticketCount = ticketCount;
		}
//		this.ticketPrice = ticketPrice;
	}

	public Performer getPerformer()
	{
		return performer;
	}

	public void setPerformer(final Performer performer)
	{
		this.performer = performer;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(final Location location)
	{
		this.location = location;
	}

//	public Date getDate()
//	{
//		return date;
//	}
//
//	public void setDate(final Date date)
//	{
//		this.date = date;
//	}

	public String getEventName()
	{
		return eventName;
	}

	public void setEventName(final String eventName)
	{
		this.eventName = eventName;
	}

	public int getTicketCount()
	{
		return ticketCount;
	}

	public void setTicketCount(final int ticketCount)
	{
		this.ticketCount = ticketCount;
	}

//	public Long getTicketPrice()
//	{
//		return ticketPrice;
//	}
//
//	public void setTicketPrice(final Long ticketPrice)
//	{
//		this.ticketPrice = ticketPrice;
//	}

	public int hashCode()
	{
		return eventName.hashCode(); //performer.hashCode() + location.hashCode() + date.hashCode();
	}

	public boolean equals(final Object other)
	{
		if(other != null && other instanceof Event)
		{
			final Event otherEvent = (Event)other;
			return eventName.equalsIgnoreCase(otherEvent.getEventName());
//			return performer.equals(otherEvent.getPerformer()) &&
//					location.equals(otherEvent.getLocation()) && 
//					date.equals(otherEvent.getDate());
		}
		return false;
	}

}
