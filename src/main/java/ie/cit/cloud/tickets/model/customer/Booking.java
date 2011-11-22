package ie.cit.cloud.tickets.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

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
	private Customer customer;
	
	@NotEmpty
	private Event event;
	
	public Booking()
	{
		
	}
	
	private Booking(final Customer customer, final Event event)
	{
		this.customer = customer;
		this.event = event;
	}

	public final Long getId()
	{
		return id;
	}

	public final void setId(final Long id)
	{
		this.id = id;
	}

	public final Customer getCustomer()
	{
		return customer;
	}

	public final void setCustomer(final Customer customer)
	{
		this.customer = customer;
	}

	public final Event getEvent()
	{
		return event;
	}

	public final void setEvent(final Event event)
	{
		this.event = event;
	}

	
}
