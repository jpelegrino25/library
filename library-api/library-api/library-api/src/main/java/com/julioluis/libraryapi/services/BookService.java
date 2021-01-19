package com.julioluis.libraryapi.services;

import com.julioluis.libraryapi.entities.Book;
import com.julioluis.libraryapi.models.GenericResponse;
import com.julioluis.libraryapi.utils.BusinessException;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface BookService {
    GenericResponse<List<Book>> findAll(Pageable pageable,Integer startPage,Integer pageSize,String sort);

    GenericResponse<Book> findBookById(Long bookId);
}
