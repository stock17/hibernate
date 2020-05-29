import org.hibernate.*;

import java.sql.SQLOutput;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Message message = new Message("Hello, world!");
        Long msgId = (Long) session.save(message);
        tx.commit();
        session.close();

        Session newSession = HibernateUtil.getSessionFactory().openSession();
        Transaction newTransaction = session.beginTransaction();
        List<Message> messages = newSession.createQuery("from Message m order by m.text asc").list();
        System.out.println(messages.size() + " message(s) found:");
        for (Message m : messages) {
            System.out.println(m.getText());
        }
        newTransaction.commit();
        newSession.close();
        HibernateUtil.shutdown();




    }
}
