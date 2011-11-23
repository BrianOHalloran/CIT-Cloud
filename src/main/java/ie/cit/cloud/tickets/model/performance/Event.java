package ie.cit.cloud.tickets.model.performance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
	private Performer performer;

	@NotEmpty
	private Location location;
	
	@NotEmpty
	private Date date;

	@NotEmpty
	private String eventName;

	@NotEmpty
	private int ticketCount;

	public Event()
	{
		
	}
	
	public Event(final Performer performer, final Location location, final Date date, final String eventName, final int ticketCount)
	{
		this.performer = performer;
		this.location = location;
		this.date = date;
		this.eventName = eventName;
		this.ticketCount = ticketCount;
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

	public final int getTicketCount()
	{
		return ticketCount;
	}

	public final void setTicketCount(final int ticketCount)
	{
		this.ticketCount = ticketCount;
	}

	
}
