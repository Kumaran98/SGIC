package com.book1.book1.main;

import com.book1.book1.entity.users;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Book1Application {

    public static void main(String[] args) {
        try {
            // Create JAXB context and unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Specify the XML file to read
            File xmlFile = new File("C:\\Users\\rajes\\Downloads\\TASK1_SGIC\\bin\\src\\main\\java\\com\\book1\\book1\\xmlfiles/books.xml");

            // Unmarshal the XML file to Java object
            Books books = (Books) jaxbUnmarshaller.unmarshal(xmlFile);

            // Iterate over each book and call Database() method
            for (Book book : books.getBookList()) {
                users user = new users();
                user.Database(book.getId(), book.getBookName(), book.getAuthorName(), book.getLanguage());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
