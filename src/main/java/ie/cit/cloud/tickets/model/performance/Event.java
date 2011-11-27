package ie.cit.cloud.tickets.model.performance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Event
{
	@Id
	@GeneratedValue
	private String id;

	@NotEmpty
	@OneToOne
	private Performer performer;

	@NotEmpty
	@OneToOne
	private Location location;

	@NotEmpty
	private Date date;

	@NotEmpty
	private String eventName;

	@NotEmpty
	private int ticketCount;

	@NotEmpty
	private int ticketPrice;

	public Event()
	{

	}

	public Event(final Performer performer, 
			final Location location, 
			final Date date, 
			final String eventName, 
			final int ticketCount,
			final int ticketPrice)
	{
		this.performer = performer;
		this.location = location;
		this.date = date;
		this.eventName = eventName;
		if(ticketCount > location.getMaxTicketCount())
		{
			this.ticketCount = location.getMaxTicketCount();
		}
		else
		{
			this.ticketCount = ticketCount;
		}
		this.ticketPrice = ticketPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#getId()
	 */
	public String getId()
	{
		return id;
	}

	public void setId(final String id)
	{
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#getPerformer()
	 */
	public Performer getPerformer()
	{
		return performer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.cit.cloud.tickets.model.performance.IEvent#setPerformer(ie.cit.cloud
	 * .tickets.model.performance.IPerformer)
	 */
	public void setPerformer(final Performer performer)
	{
		this.performer = performer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#getLocation()
	 */
	public Location getLocation()
	{
		return location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.cit.cloud.tickets.model.performance.IEvent#setLocation(ie.cit.cloud
	 * .tickets.model.performance.ILocation)
	 */
	public void setLocation(final Location location)
	{
		this.location = location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#getDate()
	 */
	public Date getDate()
	{
		return date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.cit.cloud.tickets.model.performance.IEvent#setDate(java.util.Date)
	 */
	public void setDate(final Date date)
	{
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#getEventName()
	 */
	public String getEventName()
	{
		return eventName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ie.cit.cloud.tickets.model.performance.IEvent#setEventName(java.lang.
	 * String)
	 */
	public void setEventName(final String eventName)
	{
		this.eventName = eventName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#getTicketCount()
	 */
	public int getTicketCount()
	{
		return ticketCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#setTicketCount(int)
	 */
	public void setTicketCount(final int ticketCount)
	{
		this.ticketCount = ticketCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#getTicketPrice()
	 */
	public int getTicketPrice()
	{
		return ticketPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.cit.cloud.tickets.model.performance.IEvent#setTicketPrice(int)
	 */
	public void setTicketPrice(final int ticketPrice)
	{
		this.ticketPrice = ticketPrice;
	}

	public int hashCode()
	{
		return performer.hashCode() + location.hashCode() + date.hashCode();
	}

	public boolean equals(final Object other)
	{
		if(other != null && other instanceof Event)
		{
			final Event otherEvent = (Event)other;
			return performer.equals(otherEvent.getPerformer()) && location.equals(otherEvent.getLocation())
					&& date.equals(otherEvent.getDate());
		}
		return false;
	}

}
