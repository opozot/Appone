package devcastzone.javaee.serwlety;

import devcastzone.javaee.Uzytkownik;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class WitajSwiecieSerwlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        UzytkownicyDAO dao = new UzytkownicyDAO();
        List<Uzytkownik> lista = dao.pobierzWszystkich();
        for (Uzytkownik u : lista)
            res.getWriter().println( u.getImie() + "" + u.getNazwisko() );
        Uzytkownik u = new Uzytkownik();
        u.setImie( "Jarosław" );
        u.setNazwisko( "Kowalski" );
        if (dao.dodajUzytkownika( u ))
            res.getWriter().println( "Dodano uzytkownika o ID = " + u.getId() );
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

    }
}
