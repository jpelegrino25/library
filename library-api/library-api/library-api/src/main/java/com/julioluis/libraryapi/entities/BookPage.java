package com.julioluis.libraryapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "book_page")
@XmlRootElement
public class BookPage implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BookPagePK bookPagePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "content", length = 2147483647)
    private String content;
    @JoinColumn(name = "book_id",referencedColumnName = "id", insertable = false,updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Book book;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BookPagePK getBookPagePK() {
        return bookPagePK;
    }

    public void setBookPagePK(BookPagePK bookPagePK) {
        this.bookPagePK = bookPagePK;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookPage bookPage = (BookPage) o;
        return bookPagePK.equals(bookPage.bookPagePK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookPagePK);
    }

    @Override
    public String toString() {
        return "BookPage{" +
                "bookPagePK=" + bookPagePK +
                ", content='" + content + '\'' +
                ", book=" + book +
                '}';
    }
}
