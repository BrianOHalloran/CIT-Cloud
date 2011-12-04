package ie.cit.cloud.tickets.model.performance;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "PERFORMER")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Performer
{
	@Id
	private String name;

	public Performer()
	{
		
	}
	
	public Performer(final String performerName)
	{
		name = performerName;
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
