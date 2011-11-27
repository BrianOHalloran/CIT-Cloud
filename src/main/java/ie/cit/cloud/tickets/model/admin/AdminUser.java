package ie.cit.cloud.tickets.model.admin;

public class AdminUser
{
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

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
