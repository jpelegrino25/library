package com.julioluis.libraryapi.repositories;

import com.julioluis.libraryapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("from Book")
    List<Book> findAll(Pageable pageable);
}
