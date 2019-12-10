package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Client;

/**
 * DataBaseHelper
 */
public class DataBaseHelper {

    private String url = "jdbc:postgresql://localhost/postgres";
    private String user = "postgres";
    private String password = "postgres";
    private Connection connection = null;

    public DataBaseHelper() {
        Connect();
    }

    private Connection Connect() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Connected to database successfully");
        } catch (SQLException e) {
            System.out.println("Cannot connect to database\n" + e.getMessage());
        }
        return this.connection;
    }

    /***********************************************************************************************************/

    public Client AddClient(Client client) {
        String sql = "INSERT INTO client(name, mail) VALUES (?, ?)";
        try (PreparedStatement ps = this.connection.prepareStatement(sql, new String[] { "idclient" })) {
            ps.setString(1, client.get_name());
            ps.setString(2, client.get_mail());
            int id = ps.executeUpdate();
            if (id > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        client.set_id(rs.getInt("idclient"));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return client;
    }

    public void DeleteClient(Client client) {
        String sql = "DELETE FROM client WHERE idclient=?";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, client.get_id());
            ps.executeUpdate();
            System.out.println("Client " + client.get_name() + " deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Client GetClient(Client client) {
        String sql = "SELECT * FROM client WHERE mail=?";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, client.get_mail());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                client.set_id(rs.getInt("idclient"));
                client.set_name(rs.getString("name"));
            }
            if (client.get_name() == null) {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return client;
    }

    public ArrayList GetAllClient(ArrayList clients) {
        Client client = null;
        String sql = "SELECT * FROM client";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clients.add(client = new Client(rs.getInt("idclient"), rs.getString("name"), rs.getString("mail")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

}