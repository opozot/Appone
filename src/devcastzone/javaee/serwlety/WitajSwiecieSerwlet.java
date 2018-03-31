package devcastzone.javaee.serwlety;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


public class WitajSwiecieSerwlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            Driver sterownik = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver( sterownik );
            Connection conn = sterownik.connect( "jdbc:mysql://localhost/szkolenie_javaee?user=root&amp;password=root&characterEncoding=utf8", null );
            PreparedStatement stmt = conn.prepareStatement( "INSERT INTO uzytkownik VALUES (NULL, ?, ?)" );
            stmt.setString( 1, "Marcin" );
            stmt.setString( 2, "Kowalski" );
            if (stmt.executeUpdate() > 0)
                res.getWriter().println( "Rekord został dodany" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

    }
}
