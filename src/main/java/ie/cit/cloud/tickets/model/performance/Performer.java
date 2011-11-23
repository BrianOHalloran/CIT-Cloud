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
public abstract class Performer
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
	
	protected Performer(final String performerName)
	{
		name = performerName;
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
}
