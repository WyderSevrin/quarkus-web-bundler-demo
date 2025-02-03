package application.data;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class StatusRepository {

    @Inject
    EntityManager em;

    public List<Status> findAll(){
        return em.createQuery("select s from Status s", Status.class).getResultList();
    }

}
