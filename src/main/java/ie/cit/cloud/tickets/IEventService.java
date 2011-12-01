package ie.cit.cloud.tickets;

import java.util.Date;
import java.util.List;

import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.customer.Customer;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

public interface IEventService
{
	void createLocation(final Location performer);

	Location getLocation(final String name);

	List<Location> getLocations();

	Performer getPerformer(final String name);

	List<Performer> getPerformers();

	Performer createPerformer(final String name);
	void createPerformer(final Performer performer);

	void deletePerformer(final String performerName);

	List<Event> getEvents();

	List<Event> getEventsFor(final String performerName);

	List<Event> getEventsAt(final String locationName);

	List<Event> getEvents(final String performerName, final String locationName);

	Event getEvent(final String performerName, final String locationName, final Date eventDate);

	Event createEvent(final String performer, 
			final String location, 
			final String eventName, 
			final Long ticketCount);
//	Event createEvent(final String performer, 
//			final String location, 
//			final Date date, 
//			final String eventName, 
//			final Long ticketCount,
//			final Long ticketPrice);

	List<Booking> getBookings();
	
	long createBooking(String performerName, String locationName, int numTickets);
}
