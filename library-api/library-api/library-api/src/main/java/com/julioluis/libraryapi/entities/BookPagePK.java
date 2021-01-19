package com.julioluis.libraryapi.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookPagePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "book_id")
    @NotNull
    private Long bookId;
    @Basic(optional = false)
    @Column(name = "page_number")
    @NotNull
    private Long pageNumber;

    public BookPagePK(@NotNull Long bookId, @NotNull Long pageNumber) {
        this.bookId = bookId;
        this.pageNumber = pageNumber;
    }

    public BookPagePK() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookPagePK that = (BookPagePK) o;
        return bookId.equals(that.bookId) &&
                pageNumber.equals(that.pageNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, pageNumber);
    }

    @Override
    public String toString() {
        return "BookPagePK{" +
                "bookId=" + bookId +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
