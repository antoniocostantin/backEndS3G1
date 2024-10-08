package antoniocostantini;

import antoniocostantini.dao.EventiDAO;
import antoniocostantini.entities.Evento;
import antoniocostantini.entities.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jdk.jfr.EventType;

import java.time.LocalDate;

import static antoniocostantini.entities.EventType.PRIVATO;
import static antoniocostantini.entities.EventType.PUBLICO;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventiDAO dao = new EventiDAO(em);

        Evento evento = new Evento( "tit44","UA44UAUAU", LocalDate.now(), PRIVATO, 124353);

        try{

            Evento found = dao.findById(4);
            System.out.println(found);
            dao.delteById(4);
        }
        catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }

        em.close();
        emf.close();

    }
}
