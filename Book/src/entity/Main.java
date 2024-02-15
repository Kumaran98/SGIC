package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Parse XML and filter books
        List<Book> filteredBooks = XMLParser.parseAndFilterBooks("C:\\Users\\rajes\\eclipse-workspace\\Book\\src\\entity/book.xml");
        

        // Connect to MySQL database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books", "root", "1234")) {
            // Insert filtered books into database
            for (Book book : filteredBooks) {
                String sql = "INSERT INTO books2 (id, bookName, authorName, language) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, book.getId());
                    statement.setString(2, book.getbookName());
                    statement.setString(3, book.getAuthorname());
                    statement.setString(4, book.getLanguage());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
