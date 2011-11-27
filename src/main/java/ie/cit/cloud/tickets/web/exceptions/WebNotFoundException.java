package ie.cit.cloud.tickets.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class WebNotFoundException extends RuntimeException
{
	private String notFoundElementIdentifier;
	
	public WebNotFoundException(final String identifier)
	{
		notFoundElementIdentifier = identifier;
	}

	public String getNotFoundElementIdentifier()
	{
		return notFoundElementIdentifier;
	}
}
