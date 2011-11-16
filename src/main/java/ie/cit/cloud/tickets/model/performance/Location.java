package ie.cit.cloud.tickets.model.performance;

public class Location
{
	private String id;

	private String name;

	public Location(final String locationId, final String locationName)
	{
		id = locationId;
		name = locationName;
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
