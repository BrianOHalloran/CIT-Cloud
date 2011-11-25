package ie.cit.cloud.tickets.logging;

import ie.cit.cloud.tickets.IEventService;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCatalog
{
	@Pointcut("execution(* ie.cit.cloud..IEventService.getEvent*(..)) && target(eventService)")
	public void iEventServiceGetEventX(final IEventService eventService) { }
	
	@Pointcut("execution (* (@org.springframework.stereotype.Repository ie.cit.cloud.tickets..*).*(..))")
	public void repositoryCalls() { }
	
	@Pointcut("execution (@org.springframework.transaction.annotation.Transactional * *(..))")
	public void transactionalCalls() { }
}
