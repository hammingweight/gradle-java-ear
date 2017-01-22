package javaeems.chapter1.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


@Stateful
public class ModelEJB {
    @PersistenceUnit
   private EntityManagerFactory emf;
    
    public void putUserMessage(String messageString) throws MessageException {
        this.deleteMessage();
        try {
            String decodedMessage = URLDecoder.decode(messageString, "UTF-8");
            Message message = new Message("1", "(" + messageString + ")" + " in a DB");
            EntityManager em = emf.createEntityManager();
            em.persist(message);
        } catch (UnsupportedEncodingException uee ) {
            throw new MessageException("something odd about that message..." + messageString);
        }
    }
    
    public String getStoredMessage() throws MessageException {
        EntityManager em = emf.createEntityManager();
        List messages = em.createNamedQuery("findMessages").getResultList();
        if (messages.size() > 0) {
            Message message = (Message) messages.get(0);
            return "(" + message.getMessageString() + "), inside an EJB";
        } else {
            throw new MessageException("There was nothing in the database.");
        }  
    }
    
    public void deleteMessage() {
        EntityManager em = emf.createEntityManager();
        em.createNamedQuery("deleteMessages").executeUpdate();
    }
    
}
