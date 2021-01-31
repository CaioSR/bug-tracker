package models.persistance;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * 
 * @author Caio Shimada
 *
 */
public class HibernateConnector {

  private static final SessionFactory sessionFactory = buildSessionFactory();
  private static final String DB_HOST = "localhost";
  private static final String DB_USER = "root";
  @SuppressWarnings("unused")
  private static final String DB_PASS = "";
  private static final String DB_NAME = "bug-tracker";

  /**
   * Loads the Hibernate configuration file
   *
   * @author Caio Shimada
   * 
   * @param test a boolean that defines if the configuration file to be used is for tests or not
   * @return a SessionFactory object
   */
  private static SessionFactory buildSessionFactory() {
    try {
        return new Configuration()
            .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
            .setProperty("hibernate.connection.url",
            		"jdbc:mysql://"+DB_HOST+"/"+DB_NAME+"?useTimezone=true&serverTimezone=UTC")
            .setProperty("hibernate.connection.username", DB_USER)
            .setProperty("hibernate.jdbc.time_zone", "UTC")
            .setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB53Dialect")
            .setProperty("hibernate.show_sql", "true").setProperty("hibernate.format_sql", "false")
            .setProperty("hibernate.hbm2ddl.auto", "update")
            .setProperty("hibernate.connection.autocommit", "true")
            .buildSessionFactory();

    } catch (Throwable e) {
      System.err.println("Initial SessionFactory creation failed: " + e);
      throw new ExceptionInInitializerError(e);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static void shutdown() {
    getSessionFactory().close();
  }
}

