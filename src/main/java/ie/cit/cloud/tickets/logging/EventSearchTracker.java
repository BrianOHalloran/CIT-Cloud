package ie.cit.cloud.tickets.logging;

import ie.cit.cloud.tickets.IEventService;
import ie.cit.cloud.tickets.model.performance.Event;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventSearchTracker extends TicketLogger
{
	@Before("ie.cit.cloud.tickets.logging.PointcutCatalog.iEventServiceGetX(eventService)")
	public void logEventSearch(final JoinPoint joinPoint, final IEventService eventService)
	{
		final String callingMethod = joinPoint.getSignature().getName();
		final Object[] callingArguments = joinPoint.getArgs();
		if(callingArguments != null)
		{
			if(callingArguments.length > 0)
			{
				final StringBuffer stringBuf = new StringBuffer();
				stringBuf.append(callingMethod);
				stringBuf.append(" is searching with ");
				for(int i = 0; i < callingArguments.length; i++)
				{
					stringBuf.append(callingArguments[i]);
					if(i < callingArguments.length - 1)
					{
						stringBuf.append(", ");
					}
				}
				stringBuf.append(" from ");
				stringBuf.append(eventService.getClass().getSimpleName());
				logger.info(stringBuf.toString());
			}
			else
			{
				logger.info(callingMethod + " is searching - no input arguments from " + eventService.getClass().getSimpleName());
			}
		}
		else
		{
			logger.warn(callingMethod + " is searching - input arguments is null from " + eventService.getClass().getSimpleName());
		}
	}

	@AfterReturning(value = "ie.cit.cloud.tickets.logging.PointcutCatalog.iEventServiceGetX(eventService)", returning = "events")
	public void logEventSearchDone(final JoinPoint joinPoint, final IEventService eventService, final List<Event> events)
	{
		final String callingMethod = joinPoint.getSignature().getName();
		if(events != null)
		{
			logger.info(callingMethod + " event search returning from " + eventService.getClass().getSimpleName() + " with event count = "
					+ events.size());
		}
		else
		{
			logger.warn(callingMethod + " event search returning from " + eventService.getClass().getSimpleName() + " - no events");
		}
	}

	@AfterThrowing(value = "ie.cit.cloud.tickets.logging.PointcutCatalog.iEventServiceGetX(eventService)", throwing = "e")
	public void logEventSearchExceptopn(final JoinPoint joinPoint, final IEventService eventService, final Exception e) throws Exception
	{
		final String callingMethod = joinPoint.getSignature().getName();
		logger.error(callingMethod + " event search throws " + e.getClass().getSimpleName() + " with message " + e.getMessage());

		throw e;
	}
}
