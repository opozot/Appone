package devcastzone.javaee.sluchacze;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

public class SluchaczKontekstu implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println( "Start stop: " + new Date() );
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println( "Start aplikacji: " + new Date() );
    }
}
