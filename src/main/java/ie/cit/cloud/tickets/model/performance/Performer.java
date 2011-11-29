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
@Table(name = "PERFORMER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Performer
{
	@Id
	@GeneratedValue
	private Long id;

	@Basic
	@NotEmpty
	private String name;

	public Performer()
	{
		
	}
	
	public Performer(final String performerName)
	{
		name = performerName;
	}
	
	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.performance.IPerformer#getId()
	 */
	public Long getId()
	{
		return id;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.performance.IPerformer#getName()
	 */
	public String getName()
	{
		return name;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.performance.IPerformer#setName(java.lang.String)
	 */
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public boolean equals(final Object other)
	{
		if(other != null && other instanceof Performer)
		{
			return name.equals(((Performer)other).getName());
		}
		return false;
	}
}
