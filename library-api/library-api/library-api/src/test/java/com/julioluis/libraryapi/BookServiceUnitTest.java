package com.julioluis.libraryapi;

import com.julioluis.libraryapi.entities.Book;
import com.julioluis.libraryapi.helper.BookHelper;
import com.julioluis.libraryapi.models.GenericResponse;
import com.julioluis.libraryapi.repositories.BookRepository;
import com.julioluis.libraryapi.services.impl.BookServiceImpl;
import com.julioluis.libraryapi.utils.BusinessException;
import com.julioluis.libraryapi.utils.Constants;
import javassist.runtime.Desc;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookServiceUnitTest {


    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookHelper bookHelper;
    @InjectMocks
    private BookServiceImpl bookService;



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllBooks(){
        Book book1=new Book();
        book1.setTitle("Title 1");
        Book book2=new Book();
        book2.setTitle("Title 2");

        final Integer START_PAGE = 0;
        final Integer PAGE_SIZE=4;


        List<Book> books= Arrays.asList(book1,book2);
        Pageable pageable=PageRequest.of(0,3,Sort.by("title").descending());
        when(bookHelper.getPapeable(any(),anyInt(),anyInt(),anyString())).thenReturn(pageable);
        Page page=new PageImpl(books);
        when(bookRepository.findAll(pageable)).thenReturn(page);

        GenericResponse<List<Book>> response =bookService.findAll(pageable,START_PAGE,PAGE_SIZE, Constants.DESC);

        verify(bookRepository).findAll(pageable);
        assertEquals(true,response.isSuccess());

    }

    @Test
    public void testFindBookById() {
        Long bookId=1L;
        Book book=new Book();
        book.setId(bookId);
        Optional<Book> bookOptional=Optional.of(book);
        when(bookRepository.findById(anyLong())).thenReturn(bookOptional);

        GenericResponse<Book> response=bookService.findBookById(bookId);

        verify(bookRepository).findById(anyLong());
        assertEquals(true,response.isSuccess());



    }

}
