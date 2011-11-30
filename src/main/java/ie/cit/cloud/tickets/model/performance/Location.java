package ie.cit.cloud.tickets.model.performance;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Min;

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
	@Min(value = 1)
	private Long maxTicketCount;

	public Location()
	{
		
	}
	
	public Location(final String locationName, final Long maxTicketCount)
	{
		name = locationName;
		this.maxTicketCount = maxTicketCount;
	}
	
	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.performance.ILocation#getId()
	 */
	public Long getId()
	{
		return id;
	}
	
	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.performance.ILocation#getName()
	 */
	public String getName()
	{
		return name;
	}
	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.performance.ILocation#setName(java.lang.String)
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.performance.ILocation#getMaxTicketCount()
	 */
	public Long getMaxTicketCount()
	{
		return maxTicketCount;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.performance.ILocation#setMaxTicketCount(int)
	 */
	public void setMaxTicketCount(final Long maxTicketCount)
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
