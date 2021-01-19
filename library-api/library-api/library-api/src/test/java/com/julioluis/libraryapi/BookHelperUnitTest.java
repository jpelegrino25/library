package com.julioluis.libraryapi;

import com.julioluis.libraryapi.entities.Book;
import com.julioluis.libraryapi.helper.BookHelper;
import com.julioluis.libraryapi.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookHelperUnitTest {


    @Autowired
    private BookHelper bookHelper;

    @Before
    public void init() {

    }

    @Test
    public void testGetPageableDefault() {
        Pageable pageable= PageRequest.of(0,3, Sort.by("title").descending());
        Pageable pageableFound=bookHelper.getPapeable(pageable,null,null,null);

        assertEquals(3,pageableFound.getPageSize());
    }

    @Test
    public void testGetPageableBySpecifyParamenters() {
        Pageable pageable= PageRequest.of(0,3, Sort.by("title").descending());
        Pageable pageableFound=bookHelper.getPapeable(pageable,2,4,"desc");

        assertEquals(4,pageableFound.getPageSize());
    }



}
