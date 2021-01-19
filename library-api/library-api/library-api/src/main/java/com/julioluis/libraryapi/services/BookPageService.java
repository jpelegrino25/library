package com.julioluis.libraryapi.services;

import com.julioluis.libraryapi.entities.BookPagePK;
import com.julioluis.libraryapi.models.GenericResponse;

public interface BookPageService {

    GenericResponse<String> getPageContent(Long bookId, Long pageNumber);
}
