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
	private int maxTicketCount = 0;

	public Location()
	{
		
	}
	
	public Location(final String locationName, final int maxTicketCount)
	{
		name = locationName;
		this.maxTicketCount = maxTicketCount;
	}
	
	public Long getId()
	{
		return id;
	}
	public void setId(final Long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(final String name)
	{
		this.name = name;
	}

	public int getMaxTicketCount()
	{
		return maxTicketCount;
	}

	public void setMaxTicketCount(final int maxTicketCount)
	{
		this.maxTicketCount = maxTicketCount;
	}

	public int hashCode()
	{
		return name.hashCode() + maxTicketCount;
	}
	
	public boolean equals(final Object other)
	{
		if(other instanceof Performer)
		{
			return name.equals(((Location)other).getName()) && maxTicketCount == ((Location)other).getMaxTicketCount();
		}
		return false;
	}
}
