package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            e.printStackTrace();
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
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement(
                "INSERT INTO items (name, created) VALUES (?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(new Timestamp(System.currentTimeMillis()).toLocalDateTime()));
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
        if (findById(id) != null) {
            try (PreparedStatement preparedStatement
                         = connection.prepareStatement(
                    "UPDATE items SET name = ? WHERE id = ?")) {
                preparedStatement.setString(1, item.getName());
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (Statement statement
                     = connection.createStatement()) {
            String sql = String.format("DELETE FROM items WHERE id = %d", id);
            statement.execute(sql);
            rsl = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> allItems = new ArrayList<>();
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    allItems.add(new Item(
                            resultSet.getString("name"),
                            resultSet.getInt("id")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allItems;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemsByName = new ArrayList<>();
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    if (Objects.equals(resultSet.getString("name"), key)) {
                        itemsByName.add(new Item(
                                resultSet.getString("name"),
                                resultSet.getInt("id")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemsByName;
    }

    @Override
    public Item findById(int id) {
        Item itemById = null;
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    if (Objects.equals(resultSet.getInt("id"), id)) {
                        itemById = new Item(resultSet.getString("name"),
                                resultSet.getInt("id"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemById;
    }
}
