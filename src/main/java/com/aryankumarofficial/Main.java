package com.aryankumarofficial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/aliens";
        String userName = "root";
        String password = "1234";

        int id = 6;
        String user = "loki";

        String query = "insert into students values(?,?)";


        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, password);
//        Statement statement = connection.createStatement();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.setString(2, user);
        // ResultSet resultSet = statement.executeQuery(query);
        int count = statement.executeUpdate();
//        String userData = "";

//        while (resultSet.next()) {
//            userData = resultSet.getInt(1) + " : " + resultSet.getString(2);
//            System.out.println(userData);
//        }

        System.out.println(count + " row/s affected");


        statement.close();
        connection.close();
    }

}
