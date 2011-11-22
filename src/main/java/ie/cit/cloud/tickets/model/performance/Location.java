package ie.cit.cloud.tickets.model.performance;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "LOCATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Location
{
	@Id
	@GeneratedValue
	private Long id;

	@Basic
	@NotEmpty
	private String name;

	@Basic
	@NotEmpty
	private int maxTicketCount;

	public Location()
	{
		
	}
	
	public Location(final String locationName, final int maxTicketCount)
	{
		name = locationName;
		this.maxTicketCount = maxTicketCount;
	}
	
	public final Long getId()
	{
		return id;
	}
	public final void setId(final Long id)
	{
		this.id = id;
	}
	public final String getName()
	{
		return name;
	}
	public final void setName(final String name)
	{
		this.name = name;
	}

	public final int getMaxTicketCount()
	{
		return maxTicketCount;
	}

	public final void setMaxTicketCount(final int maxTicketCount)
	{
		this.maxTicketCount = maxTicketCount;
	}

	
}
