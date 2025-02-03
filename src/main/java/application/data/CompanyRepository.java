package application.data;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class CompanyRepository {

    @Inject
    EntityManager em;

    public List<Company> findAll(){
        return em.createQuery("select c from Company c", Company.class).getResultList();
    }

}
