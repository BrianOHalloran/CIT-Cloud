package ie.cit.cloud.tickets.model.performance;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventTest
{
	private Event event;
	private final String eventName = "Darren in Cork";
	private final Performer performer = new Performer("Darren Emmerson");
	private final Location location = new Location("Cork", 234);
	private final Integer ticketCount = 123;
	
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
		event = new Event(performer, location, eventName, ticketCount);
	}

	@After
	public void tearDown() throws Exception
	{
		event = null;
	}

	@Test
	public final void testHashCode()
	{
		Event e2 = new Event(performer, location, eventName, ticketCount);
		assertTrue(e2.hashCode() == event.hashCode());
	}

	@Test
	public final void testEvent()
	{
		Event e2 = new Event();
		assertNotNull(e2);
	}

	@Test
	public final void testEventPerformerLocationStringInteger()
	{
		Event e2 = new Event(performer, location, eventName, ticketCount);
		assertNotNull(e2);
	}

	@Test
	public final void testGetPerformer()
	{
		assertTrue(performer.equals(event.getPerformer()));
	}

	@Test
	public final void testSetPerformer()
	{
		final Performer tempPerformer = new Performer("Temp Perf");
		event.setPerformer(tempPerformer);
		try
		{
			Field eventNameField = event.getClass().getDeclaredField("performer");
			eventNameField.setAccessible(true);
			Performer performerValue = (Performer)eventNameField.get(event);
			assertTrue(tempPerformer.equals(performerValue));
		}
		catch(Exception e)
		{
			fail("setPerformer test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetLocation()
	{
		assertTrue(location.equals(event.getLocation()));
	}

	@Test
	public final void testSetLocation()
	{
		final Location tempLocation = new Location("Dublin", 999);
		event.setLocation(tempLocation);
		try
		{
			Field eventNameField = event.getClass().getDeclaredField("location");
			eventNameField.setAccessible(true);
			Location locationValue = (Location)eventNameField.get(event);
			assertTrue(tempLocation.equals(locationValue));
		}
		catch(Exception e)
		{
			fail("setLocation test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetEventName()
	{
		assertEquals(eventName, event.getEventName());
	}

	@Test
	public final void testSetEventName()
	{
		final String eventName = "Savoy Gig";
		event.setEventName(eventName);
		try
		{
			Field eventNameField = event.getClass().getDeclaredField("eventName");
			eventNameField.setAccessible(true);
			String eventNameValue = (String)eventNameField.get(event);
			assertEquals(eventName, eventNameValue);
		}
		catch(Exception e)
		{
			fail("setName test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetTicketCount()
	{
		assertTrue(ticketCount == event.getTicketCount());
	}

	@Test
	public final void testSetTicketCount()
	{
		final int ticketCount = 13;
		event.setTicketCount(ticketCount);
		try
		{
			Field ticketCountField = event.getClass().getDeclaredField("ticketCount");
			ticketCountField.setAccessible(true);
			int ticketCountValue = (Integer)ticketCountField.get(event);
			assertEquals(ticketCount, ticketCountValue);
		}
		catch(Exception e)
		{
			fail("setTicketCount test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testEqualsObject()
	{
		Event e2 = new Event(performer, location, eventName, ticketCount);
		assertTrue(event.equals(e2));
	}

}
