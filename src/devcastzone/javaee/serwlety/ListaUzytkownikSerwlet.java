package devcastzone.javaee.serwlety;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListaUzytkownikSerwlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType( "text/plain; charset=UTF-8" );
        res.getWriter().println( "Lista u¿ytkowników" );
    }
}
