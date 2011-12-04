package ie.cit.cloud.tickets.model.performance;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PerformerTest
{
	private final String performerName = "Nick Warren";
	private Performer performer;
	
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
		performer = new Performer(performerName);
	}

	@After
	public void tearDown() throws Exception
	{
		performer = null;
	}

	@Test
	public final void testHashCode()
	{
		Performer p2 = new Performer(performerName);
		assertTrue(performer.hashCode() == p2.hashCode());
	}

	@Test
	public final void testPerformer()
	{
		Performer performer = new Performer();
		assertNotNull(performer);
	}

	@Test
	public final void testPerformerString()
	{
		Performer performer = new Performer("Nick Warren");
		assertNotNull(performer);
	}

	@Test
	public final void testGetName()
	{
		assertEquals(performerName, performer.getName());
	}

	@Test
	public final void testSetName()
	{
		final String name = "Sharam";
		performer.setName(name);
		try
		{
			Field nameField = performer.getClass().getDeclaredField("name");
			nameField.setAccessible(true);
			String performerName = (String)nameField.get(performer);
			assertEquals(name, performerName);
		}
		catch(Exception e)
		{
			fail("setName test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testEqualsObject()
	{
		Performer p2 = new Performer(performerName);
		assertTrue(performer.equals(p2));
	}

}
