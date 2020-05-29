import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;

public class HibernateUtil {
    static SessionFactory getSessionFactory(){
        return new SessionFactory();
    }
}
