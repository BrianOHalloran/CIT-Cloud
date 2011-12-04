package ie.cit.cloud.tickets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import ie.cit.cloud.tickets.model.IEventRepository;
import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class EventServiceTest
{
	private IEventService eventService;
	private IEventRepository repository;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
		repository = Mockito.mock(IEventRepository.class);
		eventService = new EventService(repository);
	}

	@After
	public void tearDown() throws Exception
	{
		eventService = null;
		repository = null;
	}

	@Test
	public void testEventService()
	{
		IEventService service = new EventService(repository);
		assertNotNull(service);
	}

	@Test
	public void testGetPerformers()
	{
		List<Performer> performers = eventService.getPerformers();
		assertNotNull(performers);
		assertTrue(performers.isEmpty());
	}

	@Test
	public void testGetPerformer()
	{
		assertNull(eventService.getPerformer("U2"));
	}

	@Test
	public void testCreatePerformerPerformer()
	{
		Performer performer = new Performer("John Digweed");
		eventService.createPerformer(performer);
		Mockito.verify(repository).createPerformer(performer);
	}

	@Test
	public void testDeletePerformer()
	{
		String performerName = "Sasha";
		eventService.deletePerformer(performerName);
		Mockito.verify(repository).deletePerformer(performerName);
	}

	@Test
	public void testGetLocations()
	{
		List<Location> locations = eventService.getLocations();
		assertNotNull(locations);
		assertTrue(locations.isEmpty());
	}

	@Test
	public void testCreateLocation()
	{
		Location location = new Location("Sir Henrys", 2500);
		eventService.createLocation(location);
		Mockito.verify(repository).createLocation(location);
	}

	@Test
	public void testGetLocation()
	{
		assertNull(eventService.getLocation("Sir Henrys"));
	}

	@Test
	public void testGetEvents()
	{
		List<Event> events = eventService.getEvents();
		assertNotNull(events);
		assertTrue(events.isEmpty());
	}

	@Test
	public void testGetEventsFor()
	{
		List<Event> events = eventService.getEventsFor("Paul Oakenfold");
		assertNotNull(events);
		assertTrue(events.isEmpty());
	}

	@Test
	public void testGetEventsAt()
	{
		List<Event> events = eventService.getEventsAt("Henrys");
		assertNotNull(events);
		assertTrue(events.isEmpty());
	}

	@Test
	public void testGetEvent()
	{
		Event event = eventService.getEvent("Paul Oakenfold", "Henrys");
		assertNull(event);
	}

	@Test
	public void testCreateEvent()
	{
		assertNull(eventService.createEvent(null, null, null, 0));
		assertNull(eventService.createEvent("Paul Oakenfold", "Henrys", "Oakey comes to Henrys", 1500));
	}

	@Test
	public void testGetBookings()
	{
		List<Booking> bookings = eventService.getBookings();
		assertNotNull(bookings);
		assertTrue(bookings.isEmpty());
	}

	@Test
	public void testCreateBooking()
	{
		long bookingNumber = eventService.createBooking("Paul Oakenfold", "Henrys", 4);
		
		assertNotNull(bookingNumber);
		assertEquals(0, bookingNumber);
	}

}
