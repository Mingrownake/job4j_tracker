package ru.job4j.tracker;

import ru.job4j.stream.mapto.Person;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection connection;

    public  SqlTracker() throws SQLException {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() throws SQLException {
        try  (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
//        try (Statement statement = connection.createStatement()) {
//            String sql =
//                    String.format("INSERT INTO item (name, created_date) VALUES ('%s', '%s')"
//                                    + "RETURNING (id);",
//                            item.getName(),
//                            item.getLocalDateTime().toLocalDate()
//                    );
//            statement.execute(sql);
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement("INSERT INTO item (name, created_date) VALUES (?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, String.valueOf(item.getLocalDateTime().toLocalDate()));
            preparedStatement.execute();
            try (ResultSet generatedKey = preparedStatement.getGeneratedKeys()) {
                if (generatedKey.next()) {
                    item.setId(generatedKey.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        return false;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Item> findAll() {
        return List.of();
    }

    @Override
    public List<Item> findByName(String key) {
        return List.of();
    }

    @Override
    public Item findById(int id) {
        return null;
    }
}
