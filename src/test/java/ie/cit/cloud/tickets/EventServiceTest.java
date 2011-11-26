package ie.cit.cloud.tickets;

import static org.junit.Assert.*;

import ie.cit.cloud.tickets.model.IEventRepository;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.util.List;

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

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class EventServiceTest //extends org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
{
	@Autowired
	@Qualifier("eventRepositoryStub")
	IEventRepository repository;
	
	IEventService service;
	
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
	@Transactional
	public final void testEventService()
	{
		final IEventService service = new EventService();
		assertNotNull(service);
	}

	@Test
	@Transactional
	public final void testGetLocation()
	{
		final Location location = service.getLocation("Cork");
		assertNotNull(location);
		assertEquals("Cork", location.getName());
	}

	@Test
	@Transactional
	public final void testGetLocations()
	{
		assertNotNull(service.getLocations());
		assertEquals(2, service.getLocations().size());
	}

	@Test
	@Transactional
	public final void testGetPerformer()
	{
		final Performer performer = service.getPerformer("U2");
		assertNotNull(performer);
		assertEquals("U2", performer.getName());
	}

	@Test
	@Transactional
	public final void testGetPerformers()
	{
		assertNotNull(service.getPerformers());
		assertEquals(3, service.getPerformers().size());
	}

	@Test
	@Transactional
	public final void testGetEvents()
	{
		final List<Event> events = service.getEvents("", ""); 
		assertNotNull(events);
		assertEquals(5, events.size());
	}

}
