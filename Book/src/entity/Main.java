package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

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
        } catch (SQLException s) {
        	
        	if (s.getErrorCode() == 1062) { // MySQL error code duplicate primary key 1062          
                System.out.println("Duplicate primary key violation occurred. The duplicate data given below");
                int primaryKeyValue = Integer.parseInt(s.getMessage().split("'")[1]);
                try	(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books", "root", "1234")) {
                	String sql1 = "SELECT * FROM books2 WHERE id = ?";
                       	PreparedStatement statement = connection.prepareStatement(sql1);
                       	statement.setInt(1, primaryKeyValue);
                       	ResultSet resultSet = statement.executeQuery();
                       	if (resultSet.next()) {
                            
                            int id = resultSet.getInt("id");
                            String bookName = resultSet.getString("bookName");
                            String AuthorName = resultSet.getString("authorName");
                            String Language = resultSet.getString("Language");
                            
                            
                            System.out.println("ID: " + id + ", Book Name: " + bookName + ", Author Name: " + AuthorName + ", Language: "+ Language);
                        } else {
                            System.out.println("No data found for the given Duplicate ID.");
                        }}
                catch(SQLException e) {
                	e.printStackTrace();
                }
                
            } else {
                s.printStackTrace();
            }
 //       	 
       
        }
    }
}
