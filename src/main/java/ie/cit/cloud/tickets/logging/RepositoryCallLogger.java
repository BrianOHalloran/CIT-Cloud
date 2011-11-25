package ie.cit.cloud.tickets.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class RepositoryCallLogger extends TicketLogger
{
	@Before("ie.cit.cloud.tickets.logging.PointcutCatalog.repositoryCalls()")
	public void repositoryCallLogger(final JoinPoint joinPoint)
	{
		final String callingMethod = joinPoint.getSignature().getName();
		final Object[] callingArguments = joinPoint.getArgs();
		
		if(callingArguments != null)
		{
			if(callingArguments.length > 0)
			{
				final StringBuffer stringBuf = new StringBuffer();
				stringBuf.append(callingMethod);
				stringBuf.append(" on repository with arguments ");
				for(int i = 0; i < callingArguments.length; i++)
				{
					stringBuf.append(callingArguments[i]);
					if(i < callingArguments.length - 1)
					{
						stringBuf.append(", ");
					}
				}
				logger.info(stringBuf.toString());
			}
			else
			{
				logger.info(callingMethod + " on repository - no input arguments");
			}
		}
		else
		{
			logger.warn(callingMethod + " on repository - input arguments is null");
		}
	}
}
