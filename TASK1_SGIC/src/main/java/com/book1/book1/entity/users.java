package com.book1.book1.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class users {
    private int id;
    private String bookName;
    private String authorName;
    private String language;

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public users(int id, String bookName, String authorName, String language) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.language = language;
    }

    public void Database() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books", "root", "1234");
            if (connection != null) {
                System.out.println("Connected");

                String insertQuery = "INSERT INTO Books2 (id, bookName, authorName, language) VALUES (?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, bookName);
                preparedStatement.setString(3, authorName);
                preparedStatement.setString(4, language);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) affected");
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
