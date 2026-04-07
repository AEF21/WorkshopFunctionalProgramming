package se.lexicon.service;




import se.lexicon.functional.Subscriber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class SubscriberDAOImpl implements SubscriberDAO {

        private final Connection connection;

        public SubscriberDAOImpl(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void save(Subscriber subscriber) {
            String sql = "INSERT INTO subscribers(name, email) VALUES (?, ?)";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, subscriber.getName());
                stmt.setString(2, subscriber.getEmail());
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public List<Subscriber> findAll() {
            List<Flow.Subscriber> list = new ArrayList<>();
            String sql = "SELECT * FROM subscribers";

            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Subscriber s = new Subscriber(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                    list.add(s);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return list;
        }

    @Override
    public Subscriber findById(int id) {
        return null;
    }

    @Override
    public void update(Subscriber subscriber) {

    }

    @Override
    public void delete(int id) {

    }
}


