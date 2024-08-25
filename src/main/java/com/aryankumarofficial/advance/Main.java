package com.aryankumarofficial.advance;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws Exception {
        StudentDAO dao = new StudentDAO();
        dao.connect();
//        Student student = dao.getStudent(1068);
//        System.out.println(student.getsName());
//        Student s2 = new Student();
//        s2.setRollNo(1048);
//        s2.setsName("Archana");
//        dao.connect();
//        dao.addStudent(s2);
        dao.deleteStudent(1048);
    }

}

class StudentDAO {
    Connection connection;

    public void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/aryan", "root", "1234");
    }

    public Student getStudent(int rollNo) throws Exception {
        String query = "select sname from student where rollno=" + rollNo;
        Student s = new Student();
        s.setRollNo(rollNo);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        s.setsName(resultSet.getString(1));
        return s;
    }

    public void addStudent(Student s) throws Exception {
        String query = "insert into student values(?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, s.getRollNo());
        statement.setString(2, s.getsName());
        statement.executeUpdate();
    }

    public void deleteStudent(int rollNo) throws SQLException {
        String query = "delete from student where rollno=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, rollNo);
        int count = statement.executeUpdate();
        System.out.println("Row/s affected: " + count);

    }
}

class Student {
    private int rollNo;
    private String sName;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}