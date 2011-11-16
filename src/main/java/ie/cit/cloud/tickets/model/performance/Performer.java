package ie.cit.cloud.tickets.model.performance;

public abstract class Performer
{
	private String id;
	private String name;

	protected Performer(final String performerId, final String performerName)
	{
		id = performerId;
		name = performerName;
	}
	
	public final String getId()
	{
		return id;
	}

	public final void setId(final String id)
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
