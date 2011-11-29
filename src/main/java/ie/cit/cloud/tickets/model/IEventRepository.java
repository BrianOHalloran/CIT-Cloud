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
	Performer createPerformer(final String name);
	Performer getPerformer(final String performerName);
	List<Performer> getPerformers();
	void deletePerformer(final Long performerId);
	
	Location createLocation(final String locationName,
			final int ticketCount);
	Location getLocation(final String locationName);
	List<Location> getLocations();
	
	List<Event> getEvents();
	List<Event> getEventsForPerformer(final String performerName);
	List<Event> getEventsForLocation(final String locationName);
	List<Event> getEvents(final Performer performer, 
			final Location location);
	Event getEvent(final Performer performer, 
			final Location location, 
			final Date date);
	Event createEvent(final Performer performer, 
			final Location location, 
			final Date date, 
			final String eventName, 
			final int ticketCount,
			final int ticketPrice);

	Customer createCustomer(final String name, 
			final String phoneNumber, 
			final String creditCard, 
			final String username, 
			final String password);
	
	List<Booking> getCustomerBookings();
}
