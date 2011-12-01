package ie.cit.cloud.tickets.model.performance;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "LOCATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Location
{
	@Id
	private String name;

	@Basic
	@Min(value = 1)
	private Integer maxTicketCount;

	public Location()
	{
		
	}
	
	public Location(final String locationName, final Integer maxTicketCount)
	{
		name = locationName;
		this.maxTicketCount = maxTicketCount;
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
		return name.hashCode();
	}
	
	public boolean equals(final Object other)
	{
		if(other != null && other instanceof Performer)
		{
			return name.equals(((Location)other).getName());
		}
		return false;
	}
}
