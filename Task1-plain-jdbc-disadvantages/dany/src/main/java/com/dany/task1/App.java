package com.dany.task1;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");

        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE Person(id INTEGER, name VARCHAR)");
        statement.execute("INSERT INTO Person VALUES (0, 'Lily')");
        statement.execute("INSERT INTO Person VALUES (1, 'Robin')");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Person");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("NAME"));
        }

        connection.close();
        statement.close();
        resultSet.close();
        System.out.println(connection.isClosed());
    }
}
