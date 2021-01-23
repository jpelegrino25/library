package com.julioluis.libraryapi.controllers;

import com.julioluis.libraryapi.entities.Book;
import com.julioluis.libraryapi.entities.BookPagePK;
import com.julioluis.libraryapi.helper.formatter.BookFormatterFactory;
import com.julioluis.libraryapi.models.ContentFormat;
import com.julioluis.libraryapi.models.GenericResponse;
import com.julioluis.libraryapi.services.BookPageService;
import com.julioluis.libraryapi.services.BookService;
import com.julioluis.libraryapi.utils.Constants;
import com.julioluis.libraryapi.utils.MediaTypeEnum;
import com.julioluis.libraryapi.utils.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookPageService bookPageService;

    @GetMapping(path = {"","page/{page}/size/{size}/sort/{sort}"})
    public ResponseEntity<GenericResponse<List<Book>>>
            getAllBooks(@PageableDefault(size = 3, page = 0, sort = {"title"},
            direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable(name = "page",required = false) Integer startPage,
                        @PathVariable(name = "size",required = false) Integer pageSize,
                        @PathVariable(name = "sort",required = false) String sort) {

        GenericResponse<List<Book>> response=bookService.findAll(pageable,startPage,pageSize,sort);
        if(response.isSuccess()) {
            return ResponseEntity.ok().body(response);
        }

        throw new UserException(response.getMessage());

    }
    @GetMapping(path = "{bookId}")
    public ResponseEntity<GenericResponse<Book>> getBookById(@PathVariable(name = "bookId") Long bookId) {
        GenericResponse response=bookService.findBookById(bookId);
        if(response.isSuccess()) {
            return ResponseEntity.ok().body(response);
        }
        throw new UserException(response.getMessage());
    }

    @GetMapping(path = "{bookId}/page/{pageNumber}/{format}")
    public ResponseEntity<Object> getPageContent(
            @PathVariable(name = "bookId") Long bookId,
            @PathVariable(name = "pageNumber") Long pageNumber,
            @PathVariable(name = "format") String format) throws UserException {

        GenericResponse<String> response=bookPageService.getPageContent(bookId,pageNumber);

        if(response.isSuccess()) {
            ContentFormat contentFormat= BookFormatterFactory.getContentFormat(format,response.getResult());
            return ResponseEntity.ok()
                    .contentType(contentFormat.getMediaType())
                    .body(contentFormat.getContent());

        }

        throw new UserException(Constants.INCORRECT_FORMAT);

    }
}
