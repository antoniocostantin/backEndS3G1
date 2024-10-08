package antoniocostantini.dao;

import antoniocostantini.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {
    private final EntityManager entityManager;

    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento evento) {
        //creo la transizione
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(evento);
        tx.commit();
        System.out.println("Evento salvato" + evento + " con sucesso!");
    }

    public Evento findById(long id) {
        Evento found = entityManager.find(Evento.class, id);
        if (found == null) {throw new EntityNotFoundException("Evento non trovato");}
        return found;
    }

    public void delteById(long id) {
        Evento found = this.findById(id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(found);
        tx.commit();
        System.out.println("Evento " + found.getId() + " rimosso con sucesso!");
    }
}
