package ie.cit.cloud.tickets.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionalCallLogger extends TicketLogger
{
	@Before("ie.cit.cloud.tickets.logging.PointcutCatalog.transactionalCalls()")
	public void logEventSearch(final JoinPoint joinPoint)
	{
		final String callingMethod = joinPoint.getSignature().getName();
		final Object[] callingArguments = joinPoint.getArgs();
		if(callingArguments != null)
		{
			if(callingArguments.length > 0)
			{
				final StringBuffer stringBuf = new StringBuffer();
				stringBuf.append(callingMethod);
				stringBuf.append(" called with arguments ");
				for(int i = 0; i < callingArguments.length; i++)
				{
					stringBuf.append(callingArguments[i]);
					if(i < callingArguments.length - 1)
					{
						stringBuf.append(", ");
					}
				}
				stringBuf.append(" from ");
				stringBuf.append(joinPoint.getTarget().getClass().getSimpleName());
				logger.info(stringBuf.toString());
			}
			else
			{
				logger.info(callingMethod + " is called - no input arguments from " + joinPoint.getTarget().getClass().getSimpleName());
			}
		}
		else
		{
			logger.warn(callingMethod + " is called - input arguments is null from " + joinPoint.getTarget().getClass().getSimpleName());
		}
	}
}