package ie.cit.cloud.tickets.model.admin;

public class AdminUser
{
	private Long id;
	
	private String username;
	
	private String password;

	public AdminUser()
	{
		
	}
	
	public AdminUser(final String username, final String password)
	{
		this.username = username;
		this.password = password;
	}

	public Long getId()
	{
		return id;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}
}
