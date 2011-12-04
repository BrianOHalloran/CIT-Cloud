package ie.cit.cloud.tickets.model;

import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.customer.Customer;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.Date;
import java.util.List;

public interface IEventRepository
{
	void createPerformer(final Performer performer);
	Performer getPerformer(final String performerName);
	List<Performer> getPerformers();
	/**
	 * delete the performer from the repository.  If this performer has events, also delete those events.
	 * If any of those events have bookings, also delete those bookings
	 * 
	 * @param performerName
	 * @return the number of entities removed
	 */
	int deletePerformer(final String performerName);

	
	
	void createLocation(final Location location);
	Location getLocation(final String locationName);
	List<Location> getLocations();
	
	List<Event> getEvents();
	List<Event> getEventsForPerformer(final String performerName);
	List<Event> getEventsForLocation(final String locationName);
	Event getEvent(final Performer performer, final Location location);
	Event createEvent(final Performer performer, 
			final Location location, 
			final String eventName, 
			final int ticketCount);

	void createCustomer(final Customer customer);
	
	List<Booking> getCustomerBookings();
	
	long createCustomerBooking(final String performerName, final String locationName, final int ticketCount);
}
