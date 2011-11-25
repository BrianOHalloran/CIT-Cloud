package ie.cit.cloud.tickets.logging;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCatalog
{
	@Pointcut("execution(* ie.cit.cloud..IEventService.getEvent*(..))")
	public void iEventServiceGetEventX() { }
	
	@Pointcut("execution (* (@org.springframework.stereotype.Repository ie.cit.cloud.tickets..*).*(..))")
	public void repositoryCalls() { }
}
