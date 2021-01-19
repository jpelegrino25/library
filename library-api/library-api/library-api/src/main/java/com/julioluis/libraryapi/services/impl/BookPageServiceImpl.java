package com.julioluis.libraryapi.services.impl;

import com.julioluis.libraryapi.entities.BookPage;
import com.julioluis.libraryapi.entities.BookPagePK;
import com.julioluis.libraryapi.models.GenericResponse;
import com.julioluis.libraryapi.repositories.BookPageRepository;
import com.julioluis.libraryapi.services.BookPageService;
import com.julioluis.libraryapi.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class BookPageServiceImpl implements BookPageService {

    private final Logger LOGGER= LoggerFactory.getLogger(BookPageServiceImpl.class);

    @Autowired
    private BookPageRepository bookPageRepository;

    @Override
    public GenericResponse<String> getPageContent(Long bookId,Long pageNumber) {
        GenericResponse<String> response=new GenericResponse<>();
        LOGGER.info("bookId: "+bookId+" pageNumber: "+pageNumber);
        try {
            BookPage bookPage=bookPageRepository.findBookPageByBookPagePK(new BookPagePK(bookId,pageNumber));
            LOGGER.info("Repository Result: "+bookPage);

            if(Objects.nonNull(bookPage)) {
                response.setResult(bookPage.getContent());
                response.setSuccess(Boolean.TRUE);
                return response;
            }
            response.setSuccess(Boolean.FALSE);
            response.setMessage(Constants.VALUE_NOT_FOUND);
            LOGGER.info("Repository Fail: ");
            return response;
        }catch (Exception ex) {
            LOGGER.error("Fail to get the page Content: ",ex);
            response.setSuccess(Boolean.FALSE);
            response.setMessage(ex.getMessage());
            return response;

        }

    }
}
