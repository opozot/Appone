package devcastzone.javaee.serwlety;

import devcastzone.javaee.Uzytkownik;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class WitajSwiecieSerwlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Uzytkownik u = new Uzytkownik();
        u.setId( 1 );
        u.setImie( "Jan" );
        u.setNazwisko( "Kowalski" );
        req.setAttribute( "uzytkownik", u );
        RequestDispatcher rd = req.getRequestDispatcher( "/index.jsp" );
        rd.forward( req, res );
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

    }
}
