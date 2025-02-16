package application.data;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ContactRepository {

    @Inject
    EntityManager em;

    public List<Contact> findAll(){
        return em.createQuery("select c from Contact c", Contact.class).getResultList();
    }

    public List<Contact> search(String stringFilter) {
        return em.createQuery("select c from Contact c where c.firstname like :stringFilter", Contact.class)
                .setParameter("stringFilter", stringFilter)
                .getResultList();
    }

    public long count() {
        return this.findAll().stream().count();
    }

    @Transactional
    public void delete(Contact contact) {
        em.remove(em.contains(contact) ? contact : em.merge(contact));
    }

    @Transactional
    public void save(Contact contact) {
        em.persist(em.contains(contact) ? contact : em.merge(contact));
    }
}
