package ie.cit.cloud.tickets.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//@ContextConfiguration(locations = { "/testing-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class EventRepositoryTest
{
	@Autowired
	@Qualifier("hibernateEventRepository")
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
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testEventRepository()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testCreatePerformer()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePerformer()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetPerformer()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetPerformers()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testCreateLocation()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocation()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocations()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetEvents()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetEventsPerformerLocation()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetEvent()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testCreateEvent()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetEventsForPerformer()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetEventsForLocation()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testCreateCustomer()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomerBookings()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testCreateCustomerBooking()
	{
		fail("Not yet implemented");
	}

}
