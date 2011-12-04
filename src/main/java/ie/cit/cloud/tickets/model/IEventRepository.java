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
	void deletePerformer(final String performerName);

	
	
	void createLocation(final Location location);
	Location getLocation(final String locationName);
	List<Location> getLocations();
//	void deleteLocation(final Location location);
	
	List<Event> getEvents();
	List<Event> getEventsForPerformer(final String performerName);
	List<Event> getEventsForLocation(final String locationName);
//	List<Event> getEvents(final Performer performer, 
//			final Location location);
	Event getEvent(final Performer performer, final Location location);
//	Event getEvent(final Performer performer, 
//			final Location location, 
//			final Date date);
	Event createEvent(final Performer performer, 
			final Location location, 
//			final Date date, 
			final String eventName, 
			final int ticketCount//,
//			final Long ticketPrice
			);

	void createCustomer(final Customer customer);
	
	List<Booking> getCustomerBookings();
	
	long createCustomerBooking(final String performerName, final String locationName, final int ticketCount);
}
