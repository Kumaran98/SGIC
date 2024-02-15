package entity;

public class Book {
    private int id;
    private String authorname;
    private String bookname;
    private String language;

    // Constructor
    public Book(int id, String bookname, String authorname, String language) {
        this.id = id;
        this.bookname = bookname;
        this.authorname = authorname;
        this.language = language;
    }


	// Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getbookName() {
        return bookname;
    }

    public void setbookName(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}