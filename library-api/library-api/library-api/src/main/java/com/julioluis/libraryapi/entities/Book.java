package com.julioluis.libraryapi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
@XmlRootElement
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    @Column(name = "create_at")
    @NotNull
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    @Column(name = "updated_at")
    @NotNull
    private Date updateAt;
    @Column(name = "author")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String author;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    @JsonManagedReference
    private List<BookPage> bookPages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<BookPage> getBookPages() {
        return bookPages;
    }

    public void setBookPages(List<BookPage> bookPages) {
        this.bookPages = bookPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) &&
                title.equals(book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", author='" + author + '\'' +
                '}';
    }
}
