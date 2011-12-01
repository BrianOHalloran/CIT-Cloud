package ie.cit.cloud.tickets.model.performance;

import java.io.Serializable;

public class EventPK implements Serializable 
{
	private Performer performer;
	
	private Location location;
	
	public Performer getPerformer()
	{
		return performer;
	}

	public void setPerformer(Performer performer)
	{
		this.performer = performer;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public boolean equals(final Object other)
	{
		if(other != null && other instanceof EventPK)
		{
			final EventPK otherEventPK = (EventPK)other;
			return performer.equals(otherEventPK.getPerformer()) && location.equals(otherEventPK.getLocation());
		}
		return false;
	}
	
	public int hashCode()
	{
		return performer.hashCode() + location.hashCode();
	}
}
