package emailverwaltung;

import java.sql.*;

public class EmailKontaktDAO {

    private int id;
    private String Vorname;
    private String Nachname;
    private String Email;



    public EmailKontaktDAO() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String datei = "kunde.db";
        String url = "jsbc:sqlite:" + datei;
        try {
            Connection connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmailKontakt select(int id) throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String datei = "kunde.db";
        String url = "jsbc:sqlite:" + datei;

        EmailKontakt emailKontakt = new EmailKontakt();

        Connection connection = DriverManager.getConnection(url);
        String sql = "SELECT * FROM email WHERE id LIKE ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        try {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            emailKontakt.setId(((ResultSet) resultSet).getInt("id"));
            emailKontakt.setEmail(resultSet.getString("email"));
            emailKontakt.setVorname(resultSet.getString("vorname"));
            emailKontakt.setNachname(resultSet.getString("nachname"));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();

        }


            //resulSet = preparedStatement.executeQuery();


        return emailKontakt;
    }

    public EmailKontakt first() {
        return null;
    }

    public EmailKontakt last() {
        return null;
    }

    public EmailKontakt next(EmailKontakt emailKontakt) {
        return null;
    }

    public EmailKontakt previous(EmailKontakt emailKontakt) {
        return null;
    }

    public void delete(EmailKontakt emailKontakt) {
        String sql;
        String conn =
        sql = "DELETE FROM kunde WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id); // Die Variable id enthält die ID des Datensatzes.
        statement.executeUpdate();
    }

    public void insert(EmailKontakt emailKontakt) {

    }

    public void update(EmailKontakt emailKontakt) {

    }


}
