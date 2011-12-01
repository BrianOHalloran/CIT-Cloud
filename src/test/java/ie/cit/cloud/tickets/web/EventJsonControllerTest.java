package ie.cit.cloud.tickets.web;

import static org.junit.Assert.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import ie.cit.cloud.tickets.IEventService;
import ie.cit.cloud.tickets.model.customer.Booking;
import ie.cit.cloud.tickets.model.performance.Event;
import ie.cit.cloud.tickets.model.performance.EventCreator;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;
import ie.cit.cloud.tickets.web.exceptions.WebNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class EventJsonControllerTest
{
	private EventJsonController controller;
	private IEventService eventService;

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
		eventService = Mockito.mock(IEventService.class);
		controller = new EventJsonController(eventService);
	}

	@After
	public void tearDown() throws Exception
	{
		controller = null;
		eventService = null;
	}

	@Test
	public void testEventJsonController()
	{
		EventJsonController controller = new EventJsonController(eventService);
		assertNotNull(controller);
	}

	@Test
	public void testGetPerformers()
	{
		List<Performer> list = controller.getPerformers();
		assertNotNull(list);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testGetPerformer()
	{
		String performer = "Paul Oakenfold";
		try
		{
			controller.getPerformer(performer);
		}
		catch(WebNotFoundException e)
		{
			// allowed exception
			assertEquals(performer, e.getNotFoundElementIdentifier());
		}
		catch(Exception e)
		{
			fail("Failed with " + e.getMessage());
		}
	}

	@Test
	public void testCreatePerformer()
	{
//		final Performer performer = new Performer("Sasha");
//		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//		final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
//		
//		controller.createPerformer(performer, request, response);
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDeletePerformer()
	{
		controller.deletePerformer("John Digweed");
	}

	@Test
	public void testGetLocations()
	{
		List<Location> list = controller.getLocations();
		assertNotNull(list);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testGetLocation()
	{
		String location = "Henrys";
		try
		{
			controller.getLocation(location);
		}
		catch(WebNotFoundException e)
		{
			// allowed exception
			assertEquals(location, e.getNotFoundElementIdentifier());
		}
		catch(Exception e)
		{
			fail("Failed with " + e.getMessage());
		}
	}

	@Test
	public void testGetEventByLocation()
	{
		String location = "Henrys";
		try
		{
			controller.getEventByLocation(location);
		}
		catch(WebNotFoundException e)
		{
			// allowed exception
			assertEquals(location, e.getNotFoundElementIdentifier());
		}
		catch(Exception e)
		{
			fail("Failed with " + e.getMessage());
		}
	}

	@Test
	public void testCreateLocation()
	{
//		final Location location = new Location("Red Box", 4500);
//		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//		final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
//		
//		controller.createLocation(location, request, response);
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetEvents()
	{
		List<Event> list = controller.getEvents();
		assertNotNull(list);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testGetEventByPerformer()
	{
		String performer = "Paul Oakenfold";
		try
		{
			controller.getEventByLocation(performer);
		}
		catch(WebNotFoundException e)
		{
			// allowed exception
			assertEquals(performer, e.getNotFoundElementIdentifier());
		}
		catch(Exception e)
		{
			fail("Failed with " + e.getMessage());
		}
	}

	@Test
	public void testGetEventByPerformerAndLocation()
	{
		String performer = "Paul Oakenfold";
		String location = "Henrys";
		try
		{
			controller.getEventByPerformerAndLocation(performer, location);
		}
		catch(WebNotFoundException e)
		{
			// allowed exception
			assertEquals(location, e.getNotFoundElementIdentifier());
		}
		catch(Exception e)
		{
			fail("Failed with " + e.getMessage());
		}
	}

	@Test
	public void testCreateEvent()
	{
//		final EventCreator event = new EventCreator("Sasha", "Red Box", "Sasha visits Red Box", 5000);
//		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
//		final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
//		
//		controller.createEvent(event, request, response);

		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetBookings()
	{
		List<Booking> list = controller.getBookings();
		assertNotNull(list);
		assertTrue(list.isEmpty());
	}

}
