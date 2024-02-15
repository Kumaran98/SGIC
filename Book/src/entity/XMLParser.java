package entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    public static List<Book> parseAndFilterBooks(String filePath) {
        List<Book> books = new ArrayList<>();

        try {
            File file = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                String bookName = element.getElementsByTagName("bookName").item(0).getTextContent();
                String authorName = element.getElementsByTagName("authorName").item(0).getTextContent();
                String language = element.getElementsByTagName("language").item(0).getTextContent();

                Book book = new Book(id, bookName, authorName, language);
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Filter books by position
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
    
                filteredBooks.add(book);
            
        }

        return filteredBooks;
    }
}
