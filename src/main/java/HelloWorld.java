import org.hibernate.*;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        Map<String, String> myProperties = new HashMap<>();
        myProperties.put("hibernate.hbm2ddl.auto", "create-drop");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("helloworld", myProperties);

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Message message = new Message("Hello, world!");
        em.persist(message);
        tx.commit();
        em.close();


        EntityManager em2 = emf.createEntityManager();
        EntityTransaction newTransaction = em2.getTransaction();
        newTransaction.begin();
        List<Message> messages = em2.createQuery("from Message m order by m.text asc").getResultList();
        System.out.println(messages.size() + " message(s) found:");
        for (Message m : messages) {
            System.out.println(m.getText());
        }
        newTransaction.commit();
        em2.close();

    }
}
