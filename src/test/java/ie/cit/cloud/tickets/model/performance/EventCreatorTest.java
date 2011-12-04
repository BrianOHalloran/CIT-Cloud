package ie.cit.cloud.tickets.model.performance;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventCreatorTest
{
	private EventCreator ec;
	private final String performerName = "Paul Oakenfold";
	private final String locationName = "Red Box, Dublin";
	private final String eventName = "Oakenfold event";
	private final int ticketCount = 1234;	
	
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
		ec = new EventCreator(performerName, locationName, eventName, ticketCount);
	}

	@After
	public void tearDown() throws Exception
	{
		ec = null;
	}

	@Test
	public final void testEventCreator()
	{
		EventCreator ec2 = new EventCreator();
		assertNotNull(ec2);
	}

	@Test
	public final void testEventCreatorStringStringStringInteger()
	{
		EventCreator ec2 = new EventCreator(performerName, locationName, eventName, ticketCount);
		assertNotNull(ec2);
	}

	@Test
	public final void testGetPerformerName()
	{
		assertEquals(performerName, ec.getPerformerName());
	}

	@Test
	public final void testGetLocationName()
	{
		assertEquals(locationName, ec.getLocationName());
	}

	@Test
	public final void testGetEventName()
	{
		assertEquals(eventName, ec.getEventName());
	}

	@Test
	public final void testGetTicketCount()
	{
		assertEquals(ticketCount, ec.getTicketCount());
	}
}
