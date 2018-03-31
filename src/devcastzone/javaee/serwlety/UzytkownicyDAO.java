package devcastzone.javaee.serwlety;

import devcastzone.javaee.Uzytkownik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UzytkownicyDAO {
    private Connection polaczenie;

    public UzytkownicyDAO() {
        Driver sterownik;
        try {
            sterownik = new com.mysql.jdbc.Driver();
            polaczenie = sterownik.connect( "jdbc:mysql://localhost/szkolenie_javaee?user=root&amp;password=", null );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean dodajUzytkownika(Uzytkownik u) {
        try {
            PreparedStatement stmt = this.polaczenie.prepareStatement( "INSERT INTO uzytkownik VALUES (NULL, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS );
            stmt.setString( 1, u.getImie() );
            stmt.setString( 2, u.getNazwisko() );
            boolean wynik = stmt.executeUpdate() > 0;
            if (wynik) {
                ResultSet klucze = stmt.getGeneratedKeys();
                if (klucze.next())
                    u.setId( klucze.getInt( 1 ) );
            }
            return wynik;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean zmienUzytkownika(Uzytkownik u) {
        try {
            PreparedStatement stmt = this.polaczenie.prepareStatement( "UPDATE uzytkownik SET imie = ? nazwisko = ? WHERE id = ?" );
            stmt.setString( 1, u.getImie() );
            stmt.setString( 2, u.getNazwisko() );
            stmt.setInt( 3, u.getId() );
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean usunUzytkownika(Uzytkownik u) {
        try {
            PreparedStatement stmt = this.polaczenie.prepareStatement( "DELETE uzytkownik WHERE id = ?" );
            stmt.setInt( 1, u.getId() );
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Uzytkownik pobierzUzytkownika(int id) {
        try {
            PreparedStatement stmt = this.polaczenie.prepareStatement( "SELECT * from uzytkownik WHERE id =?" );
            stmt.setInt( 1, id );
            if (stmt.execute()) {
                ResultSet rs = stmt.getResultSet();
                if (rs.next()) {
                    Uzytkownik pobrany = new Uzytkownik();
                    pobrany.setId( rs.getInt( 1 ) );
                    pobrany.setImie( rs.getString( 2 ) );
                    pobrany.setNazwisko( rs.getString( 3 ) );
                    return pobrany;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Uzytkownik> pobierzWszystkich() {
        List<Uzytkownik> wyniki = new ArrayList<Uzytkownik>();
        try {
            Statement stmt = this.polaczenie.createStatement();
            if (stmt.execute( "SELECT * from uzytkownik" )) {
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    Uzytkownik pobrany = new Uzytkownik();
                    pobrany.setId( rs.getInt( 1 ) );
                    pobrany.setImie( rs.getString( 2 ) );
                    pobrany.setNazwisko( rs.getString( 3 ) );
                    wyniki.add( pobrany );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wyniki;
    }
}