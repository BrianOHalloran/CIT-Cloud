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
@Table//(name = "PERFORMER")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public boolean equals(final Object other)
	{
		if(other instanceof Performer)
		{
			return name.equals(((Performer)other).getName());
		}
		return false;
	}
}
