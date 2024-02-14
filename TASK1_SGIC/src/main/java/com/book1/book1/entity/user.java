
package com.book1.book1.entity;

import javax.xml.bind.annotation.XmlElement;

public class user {
    private int id;
    private String bookName;
    private String authorName;
    private String language;

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    @XmlElement
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    @XmlElement
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getLanguage() {
        return language;
    }

    @XmlElement
    public void setLanguage(String language) {
        this.language = language;
    }
}