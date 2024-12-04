package usr.ivan.models;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory(String[] credenciales) {
        try {

            String host = credenciales[0];
            String port = credenciales[1];
            String dbName = credenciales[2];
            String username = credenciales[3];
            String password = credenciales[4];

            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://" + host + ":" + port + "/" + dbName);
            configuration.setProperty("hibernate.connection.username", username);
            configuration.setProperty("hibernate.connection.password", password);

            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");

            configuration.addAnnotatedClass(Task.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException("Error al iniciar hibernate: " + e.getMessage());

        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
