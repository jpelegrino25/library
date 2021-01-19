package com.julioluis.libraryapi.repositories;

import com.julioluis.libraryapi.entities.BookPage;
import com.julioluis.libraryapi.entities.BookPagePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPageRepository extends JpaRepository<BookPage,Long> {

    BookPage findBookPageByBookPagePK(BookPagePK bookPagePk);
}
