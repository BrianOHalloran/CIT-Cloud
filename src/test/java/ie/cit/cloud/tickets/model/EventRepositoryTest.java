package ie.cit.cloud.tickets.model;

import static org.junit.Assert.*;

import ie.cit.cloud.tickets.AbstractServiceTest;
import ie.cit.cloud.tickets.model.performance.Location;
import ie.cit.cloud.tickets.model.performance.Performer;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

public class EventRepositoryTest extends AbstractServiceTest 
{
	@Autowired
	@Qualifier("hibernateEventRepository")
	private IEventRepository repository;
	
	private static final String PERFORMER1 = "Sasha";
	private static final String PERFORMER2 = "Paul Oakenfold";
	
	private static final String LOCATION1 = "Henrys";
	private static final String LOCATION2 = "Savoy";

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

	@BeforeTransaction
	public void setupDb() throws Exception
	{
		final Field entityManagerField = EventRepository.class.getField("em");
		entityManagerField.setAccessible(true);
		final EntityManager em = (EntityManager)entityManagerField.get(repository);
		
		em.persist(new Performer(PERFORMER1));
		em.persist(new Performer(PERFORMER2));

		em.persist(new Location(LOCATION1, 2500));
		em.persist(new Location(LOCATION2, 1500));
	}
	
	@AfterTransaction
	public void wipeDb() throws Exception
	{
		final Field entityManagerField = EventRepository.class.getField("em");
		entityManagerField.setAccessible(true);
		final EntityManager em = (EntityManager)entityManagerField.get(repository);
		
		em.persist(new Performer(PERFORMER1));
		em.persist(new Performer(PERFORMER2));

		em.persist(new Location(LOCATION1, 2500));
		em.persist(new Location(LOCATION2, 1500));
		
		em.createQuery("delete from Performer").executeUpdate();
		em.createQuery("delete from Location").executeUpdate();
		em.createQuery("delete from Event").executeUpdate();
		em.createQuery("delete from Booking").executeUpdate();
		em.createQuery("delete from Customer").executeUpdate();
	}
	
	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCreatePerformer()
	{
//		Performer performer = new Performer("John Digweed");
//		repository.createPerformer(performer);
//
//		Field entityManagerField;
//		try
//		{
//			entityManagerField = EventRepository.class.getField("em");
//			entityManagerField.setAccessible(true);
//			final EntityManager em = (EntityManager)entityManagerField.get(repository);
//			Performer dbPerformer = em.find(Performer.class, "John Digweed");
//			assertTrue(performer.equals(dbPerformer));
//		}
//		catch(Exception e)
//		{
//			fail(e.getMessage());
//		}
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
		final List<Performer> performers = repository.getPerformers();
		assertNotNull(performers);
		assertEquals(2, performers.size());
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
