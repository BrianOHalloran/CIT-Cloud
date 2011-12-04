package ie.cit.cloud.tickets.web;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import ie.cit.cloud.tickets.IEventService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class EventWebControllerTest
{
	private EventWebController webController;
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
		webController = new EventWebController(eventService);
	}

	@After
	public void tearDown() throws Exception
	{
		webController = null;
	}

	@Test
	public void testEventWebController()
	{
		EventWebController controller = new EventWebController(eventService);
		assertNotNull(controller);
	}

	@Test
	public void testIndex()
	{
		Model model = new ExtendedModelMap();
		String returnValue = webController.index(model);
		assertEquals("index", returnValue);
		final Map<String, Object> map = model.asMap();
		assertEquals(4, map.size());
		Set<String> keys = map.keySet();
		assertTrue(keys.contains("performers"));
		assertTrue(keys.contains("locations"));
		assertTrue(keys.contains("events"));
		assertTrue(keys.contains("loggedIn"));
	}

	@Test
	public void testBookingLookup()
	{
		Model model = new ExtendedModelMap();
		String returnValue = webController.bookingLookup(model);
		assertEquals("account", returnValue);
		final Map<String, Object> map = model.asMap();
		assertEquals(4, map.size());
		Set<String> keys = map.keySet();
		assertTrue(keys.contains("bookings"));
		assertTrue(keys.contains("customerName"));
		assertTrue(keys.contains("customerPhone"));
		assertTrue(keys.contains("customerCreditCard"));
	}

	@Test
	public void testBookEvent()
	{
		final Model model = new ExtendedModelMap();
		String returnValue = webController.bookEvent("Paul Oakenfold", "Henrys", 4, model);
		assertEquals("account", returnValue);
		Map<String, Object> map = model.asMap();
		assertEquals(2, map.size());
		Set<String> keys = map.keySet();
		assertTrue(keys.contains("bookingId"));
		assertTrue(keys.contains("bookings"));
	}

}
