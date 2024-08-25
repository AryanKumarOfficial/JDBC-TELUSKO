package com.aryankumarofficial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/aliens";
        String userName = "root";
        String password = "1234";
        String query = "select * from students;";

//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        String userData = "";

        while (resultSet.next()) {
            userData = resultSet.getInt(1) + " : " + resultSet.getString(2);
            System.out.println(userData);
        }


        statement.close();
        connection.close();
    }

}
