package ie.cit.cloud.tickets.model.performance;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocationTest
{
	private final String locationName = "Sir Henrys";
	private final int ticketCount = 1234;
	private Location location;

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
		location = new Location(locationName, ticketCount);
	}

	@After
	public void tearDown() throws Exception
	{
		location = null;
	}

	@Test
	public final void testHashCode()
	{
		Location l2 = new Location(locationName, ticketCount);
		assertTrue(location.hashCode() == l2.hashCode());
	}

	@Test
	public final void testLocation()
	{
		Location l2 = new Location();
		assertNotNull(l2);
	}

	@Test
	public final void testLocationStringInteger()
	{
		Location l2 = new Location(locationName, ticketCount);
		assertNotNull(l2);
	}

	@Test
	public final void testGetName()
	{
		assertEquals(locationName, location.getName());
	}

	@Test
	public final void testSetName()
	{
		final String name = "Savoy";
		location.setName(name);
		try
		{
			Field nameField = location.getClass().getDeclaredField("name");
			nameField.setAccessible(true);
			String performerName = (String)nameField.get(location);
			assertEquals(name, performerName);
		}
		catch(Exception e)
		{
			fail("setName test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetMaxTicketCount()
	{
		assertEquals(ticketCount, location.getMaxTicketCount());
	}

	@Test
	public final void testSetMaxTicketCount()
	{
		final int maxTicketCount = 123;
		location.setMaxTicketCount(maxTicketCount);
		try
		{
			Field ticketCountField = location.getClass().getDeclaredField("maxTicketCount");
			ticketCountField.setAccessible(true);
			int ticketCount = (Integer)ticketCountField.get(location);
			assertEquals(maxTicketCount, ticketCount);
		}
		catch(Exception e)
		{
			fail("setMaxTicketCount test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testEqualsObject()
	{
		Location l2 = new Location(locationName, ticketCount);
		assertTrue(location.equals(l2));
	}

}
