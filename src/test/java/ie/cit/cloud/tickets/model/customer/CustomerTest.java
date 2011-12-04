package ie.cit.cloud.tickets.model.customer;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest
{
	private Customer customer;
	private final String name = "Brian O'Halloran";
	private final String phone = "123";
	private final String cc = "456";
	private final String username = "brian";
	private final String password = "brian1";
	
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
		customer = new Customer(name, phone, cc, username, password);
	}

	@After
	public void tearDown() throws Exception
	{
		customer = null;
	}

	@Test
	public final void testHashCode()
	{
		Customer c2 = new Customer(name, phone, cc, username, password);
		assertTrue(customer.hashCode() == c2.hashCode());
	}

	@Test
	public final void testCustomer()
	{
		Customer c2 = new Customer();
		assertNotNull(c2);
	}

	@Test
	public final void testCustomerStringStringStringStringString()
	{
		Customer c2 = new Customer(name, phone, cc, username, password);
		assertNotNull(c2);
	}

	@Test
	public final void testGetName()
	{
		assertEquals(name, customer.getName());
	}

	@Test
	public final void testSetName()
	{
		final String name = "Sharam";
		customer.setName(name);
		try
		{
			Field nameField = customer.getClass().getDeclaredField("name");
			nameField.setAccessible(true);
			String customerName = (String)nameField.get(customer);
			assertEquals(name, customerName);
		}
		catch(Exception e)
		{
			fail("setName test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetPhoneNumber()
	{
		assertEquals(phone, customer.getPhoneNumber());
	}

	@Test
	public final void testSetPhoneNumber()
	{
		final String name = "Sharam";
		customer.setPhoneNumber(name);
		try
		{
			Field nameField = customer.getClass().getDeclaredField("phoneNumber");
			nameField.setAccessible(true);
			String customerName = (String)nameField.get(customer);
			assertEquals(name, customerName);
		}
		catch(Exception e)
		{
			fail("setPhoneNumber test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetCreditCard()
	{
		assertEquals(cc, customer.getCreditCard());
	}

	@Test
	public final void testSetCreditCard()
	{
		final String name = "Sharam";
		customer.setCreditCard(name);
		try
		{
			Field nameField = customer.getClass().getDeclaredField("creditCard");
			nameField.setAccessible(true);
			String customerName = (String)nameField.get(customer);
			assertEquals(name, customerName);
		}
		catch(Exception e)
		{
			fail("setCreditCard test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetUsername()
	{
		assertEquals(username, customer.getUsername());
	}

	@Test
	public final void testSetUsername()
	{
		final String name = "Sharam";
		customer.setUsername(name);
		try
		{
			Field nameField = customer.getClass().getDeclaredField("username");
			nameField.setAccessible(true);
			String customerName = (String)nameField.get(customer);
			assertEquals(name, customerName);
		}
		catch(Exception e)
		{
			fail("setUsername test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testGetPassword()
	{
		assertEquals(password, customer.getPassword());
	}

	@Test
	public final void testSetPassword()
	{
		final String name = "Sharam";
		customer.setPassword(name);
		try
		{
			Field nameField = customer.getClass().getDeclaredField("password");
			nameField.setAccessible(true);
			String customerName = (String)nameField.get(customer);
			assertEquals(name, customerName);
		}
		catch(Exception e)
		{
			fail("setPassword test fail message = " + e.getMessage());
		}
	}

	@Test
	public final void testEqualsObject()
	{
		Customer c2 = new Customer(name, phone, cc, username, password);
		assertTrue(c2.equals(customer));
	}

}
