package ie.cit.cloud.tickets.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository("hibernateEventRepository")
public class EventRepository implements IEventRepository
{
/*
	@PersistenceContext
    private EntityManager em;
*/
}
