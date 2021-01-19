package com.julioluis.libraryapi;

import com.julioluis.libraryapi.entities.BookPage;
import com.julioluis.libraryapi.models.GenericResponse;
import com.julioluis.libraryapi.repositories.BookPageRepository;
import com.julioluis.libraryapi.services.impl.BookPageServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookPageServiceTest {
    @Mock
    private BookPageRepository bookPageRepository;
    @InjectMocks
    private BookPageServiceImpl bookPageService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindBookPage() {
        BookPage bookPage=new BookPage();
        bookPage.setContent("The life in a good fashion");

        Long bookId=1L;
        Long pageNumber=2L;

        when(bookPageRepository.findBookPageByBookPagePK(any())).thenReturn(bookPage);
        GenericResponse<String> response=bookPageService.getPageContent(bookId,pageNumber);
        verify(bookPageRepository).findBookPageByBookPagePK(any());

        assertEquals(true,response.isSuccess());

    }

}
