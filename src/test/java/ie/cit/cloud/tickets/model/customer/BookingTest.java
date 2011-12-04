package ie.cit.cloud.tickets.model.customer;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookingTest
{
	private Booking booking;
	private final int numberOfTickets = 10;
	private final Event event = new Event(new Performer("Darren Emmerson"), new Location("Cork", 234), "Darren in Cork", 123);
	private final String username = "Brian";
	
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
		booking = new Booking(username, event, numberOfTickets);
	}

	@After
	public void tearDown() throws Exception
	{
		booking = null;
	}

	@Test
	public final void testHashCode()
	{
		Booking b2 = new Booking(username, event, numberOfTickets);
		assertTrue(b2.hashCode() == booking.hashCode());
	}

	@Test
	public final void testBooking()
	{
		Booking b2 = new Booking();
		assertNotNull(b2);
	}

	@Test
	public final void testBookingStringEventInteger()
	{
		Booking b2 = new Booking(username, event, numberOfTickets);
		assertNotNull(b2);
	}

	@Test
	public final void testGetUser()
	{
		assertEquals(username, booking.getUser());
	}

	@Test
	public final void testSetUser()
	{
		final String name = "Sharam";
		booking.setUser(name);
		try
		{
			Field nameField = booking.getClass().getDeclaredField("user");
			nameField.setAccessible(true);
			String username = (String)nameField.get(booking);
			assertEquals(name, username);
		}
		catch(Exception e)
		{
			fail("setName test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetEvent()
	{
		assertTrue(event.equals(booking.getEvent()));
	}

	@Test
	public final void testSetEvent()
	{
		final Event e2 = new Event(new Performer("Darren Emmerson"), new Location("Cork", 234), "Darren in Cork", 123);
		booking.setEvent(e2);
		try
		{
			Field eventField = booking.getClass().getDeclaredField("event");
			eventField.setAccessible(true);
			Event e3 = (Event)eventField.get(booking);
			assertTrue(e2.equals(e3));
		}
		catch(Exception e)
		{
			fail("setEvent test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetNumTickets()
	{
		assertTrue(numberOfTickets == booking.getNumTickets());
	}

	@Test
	public final void testSetNumTickets()
	{
		final int newTicketCount = 123;
		booking.setNumTickets(newTicketCount);
		try
		{
			Field ticketCountField = booking.getClass().getDeclaredField("numTickets");
			ticketCountField.setAccessible(true);
			int ticketCount = (Integer)ticketCountField.get(booking);
			assertEquals(newTicketCount, ticketCount);
		}
		catch(Exception e)
		{
			fail("setNumTickets test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testEqualsObject()
	{
		Booking b2 = new Booking(username, event, numberOfTickets);
		assertTrue(b2.equals(booking));
	}

}
