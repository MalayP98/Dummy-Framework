package com.application.library.models;

public class Book {

  int bookId;
  String bookName;
  String author;
  int copies;
  String isbn;

  public Book() {
    super();
  }

  public Book(String book_name, String author, int copies, String isbn) {
    super();
    this.bookName = book_name;
    this.author = author;
    this.copies = copies;
    this.isbn = isbn;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  @Override
  public String toString() {
    return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", copies="
        + copies + ", isbn=" + isbn + "]";
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getCopies() {
    return copies;
  }

  public void setCopies(int copies) {
    this.copies = copies;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

}
