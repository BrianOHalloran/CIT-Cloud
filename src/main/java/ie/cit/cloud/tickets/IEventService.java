package ie.cit.cloud.tickets;

import java.util.List;

import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.customer.Customer;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

public interface IEventService
{
	void createPerformer(final Performer performer);
	Performer getPerformer(final String name);
	List<Performer> getPerformers();
	int deletePerformer(final String performerName);

	
	void createLocation(final Location location);
	Location getLocation(final String name);
	List<Location> getLocations();


	Event createEvent(final String performer, 
			final String location, 
			final String eventName, 
			final int ticketCount);
	Event getEvent(final String performerName, final String locationName);
	List<Event> getEventsFor(final String performerName);
	List<Event> getEventsAt(final String locationName);
	List<Event> getEvents();

	// customers not used for login, login credentials are in properties file
	void createCustomer(final Customer customer);
	
	
	List<Booking> getBookings();
	long createBooking(String performerName, String locationName, int numTickets);
}
