package com.book1.book1.main;

import com.book1.book1.entity.user;
import com.book1.book1.entity.users;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book1Application {

    public static void main(String[] args) {
        try {
            // Create JAXB context and unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Specify the XML file to read
            File xmlFile = new File("C:\\Users\\rajes\\Downloads\\TASK1_SGIC\\src\\main\\java\\com\\book1\\book1\\xmlfiles/userinput.xml");

            // Unmarshal the XML file to Java object
            users users = (users) jaxbUnmarshaller.unmarshal(xmlFile);

            // Iterate over each user/book and insert into the database
            for (user user : users.getUserList()) {
                Database(user.getId(), user.getBookName(), user.getAuthorName(), user.getLanguage());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void Database(int id, String bookName, String authorName, String language) {
        Connection connection = null;
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books", "root", "1234");
            if (connection != null) {
                System.out.println("Connected");

                // Prepare and execute SQL insert statement
                String insertQuery = "INSERT INTO Books (id, bookName, authorName, language) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, bookName);
                preparedStatement.setString(3, authorName);
                preparedStatement.setString(4, language);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) affected");
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database or execute SQL statement!");
            e.printStackTrace();
        } finally {
            // Close database connection
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