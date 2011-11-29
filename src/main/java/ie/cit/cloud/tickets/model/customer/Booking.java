package ie.cit.cloud.tickets.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import ie.cit.cloud.tickets.model.performance.Event;

@Entity
@Table(name = "BOOKING")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Booking
{
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@OneToOne
	private Customer customer;
	
	@NotEmpty
	@OneToOne
	private Event event;
	
	@Min(value = 1)
	private Integer numTickets = 0;
	
	public Booking()
	{
		
	}
	
	private Booking(final Customer customer, final Event event, final Integer numTickets)
	{
		this.customer = customer;
		this.event = event;
		this.numTickets = numTickets;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.IBooking#getId()
	 */
	public final Long getId()
	{
		return id;
	}
	
	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.IBooking#getCustomer()
	 */
	public final Customer getCustomer()
	{
		return customer;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.IBooking#setCustomer(ie.cit.cloud.tickets.model.customer.ICustomer)
	 */
	public final void setCustomer(final Customer customer)
	{
		this.customer = customer;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.IBooking#getEvent()
	 */
	public final Event getEvent()
	{
		return event;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.IBooking#setEvent(ie.cit.cloud.tickets.model.performance.IEvent)
	 */
	public final void setEvent(final Event event)
	{
		this.event = event;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.IBooking#getNumTickets()
	 */
	public int getNumTickets()
	{
		return numTickets;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.IBooking#setNumTickets(int)
	 */
	public void setNumTickets(final int numTickets)
	{
		this.numTickets = numTickets;
	}

	public int hashCode()
	{
		return customer.hashCode() + event.hashCode() + numTickets;
	}
	
	public boolean equals(final Object other)
	{
		if(other != null && other instanceof Booking)
		{
			final Booking otherBooking = (Booking)other;
			return customer.equals(otherBooking.getCustomer()) && event.equals(otherBooking.getEvent()) && numTickets == otherBooking.getNumTickets();
		}
		return false;
	}
}
