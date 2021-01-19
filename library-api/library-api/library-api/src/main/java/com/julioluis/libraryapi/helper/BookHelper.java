package com.julioluis.libraryapi.helper;

import com.julioluis.libraryapi.services.impl.BookPageServiceImpl;
import com.julioluis.libraryapi.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BookHelper {

    private final Logger LOGGER= LoggerFactory.getLogger(BookHelper.class);

    public Pageable getPapeable(Pageable pageable, Integer startPage, Integer pageSize,String sort) {
        LOGGER.info("getPapeable start executing ");
        if(Objects.nonNull(startPage) && Objects.nonNull(pageSize)) {

            Sort orders=(Constants.DESC.equalsIgnoreCase(sort))?Sort.by("title").descending() :
                    Sort.by("title").ascending();

            pageable= PageRequest.of(startPage,pageSize,orders);
        }
        LOGGER.info("getPapeable executed successfully ");
        return pageable;
    }
}
