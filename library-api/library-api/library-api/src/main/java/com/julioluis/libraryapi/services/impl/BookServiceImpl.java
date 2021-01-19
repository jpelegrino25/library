package com.julioluis.libraryapi.services.impl;

import com.julioluis.libraryapi.entities.Book;
import com.julioluis.libraryapi.helper.BookHelper;
import com.julioluis.libraryapi.models.GenericResponse;
import com.julioluis.libraryapi.repositories.BookRepository;
import com.julioluis.libraryapi.services.BookService;
import com.julioluis.libraryapi.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final Logger LOGGER= LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookHelper bookHelper;

    @Override
    public GenericResponse<List<Book>> findAll(Pageable pageable,Integer startPage,Integer pageSize,String sort)  {
        LOGGER.info("findAll start executing "+pageable );
        GenericResponse<List<Book>> response=new GenericResponse<>();
        try {
            Pageable pageableFound=bookHelper.getPapeable(pageable,startPage,pageSize,sort);
            Page page = bookRepository.findAll(pageableFound);
            response.setResult(page.getContent());

            response.setSuccess(Boolean.TRUE);
            LOGGER.info("Executed successfully "+response );
            return response;
        }catch (Exception ex) {
            response.setSuccess(Boolean.FALSE);
            response.setMessage(ex.getMessage());
            LOGGER.error("Fail to execute findAll",ex);
            return response;
        }


    }

    @Override
    public GenericResponse<Book> findBookById(Long bookId) {
        GenericResponse<Book> response=new GenericResponse<>();
        LOGGER.info("findBookById start executing "+bookId );
        try {
            Optional<Book> optionalBook=bookRepository.findById(bookId);
            if(optionalBook.isPresent()) {
                response.setResult(optionalBook.get());
                response.setSuccess(Boolean.TRUE);
                return response;
            }
            response.setSuccess(Boolean.FALSE);
            response.setMessage(Constants.VALUE_NOT_FOUND);
            LOGGER.info("Executed successfully "+response );
            return response;
        }catch (Exception ex) {
            response.setSuccess(Boolean.FALSE);
            response.setMessage(ex.getMessage());
            LOGGER.error("Fail to execute findBookById",ex);
            return response;
        }

    }
}
