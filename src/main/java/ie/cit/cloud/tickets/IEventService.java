package ie.cit.cloud.tickets;

import java.util.Date;
import java.util.List;

import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

public interface IEventService
{
	Location createLocation(final String locationName, final Long maxTicketCount);

	Location getLocation(final String name);

	List<Location> getLocations();

	Performer getPerformer(final String name);

	List<Performer> getPerformers();

	Performer createPerformer(final String name);

	void deletePerformer(final Long performerId);

	List<Event> getEvents();

	List<Event> getEventsFor(final String performerName);

	List<Event> getEventsAt(final String locationName);

	List<Event> getEvents(final String performerName, final String locationName);

	Event getEvent(final String performerName, final String locationName, final Date eventDate);

	Event createEvent(final Long performer, 
			final Long location, 
			final Date date, 
			final String eventName, 
			final Long ticketCount,
			final Long ticketPrice);

	Event createEvent(final Performer performer, 
			final Location location, 
			final Date date, 
			final String eventName, 
			final Long ticketCount,
			final Long ticketPrice);
	
	List<Booking> getBookings();
}
