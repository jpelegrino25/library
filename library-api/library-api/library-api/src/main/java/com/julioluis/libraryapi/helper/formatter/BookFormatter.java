package com.julioluis.libraryapi.helper.formatter;

import com.julioluis.libraryapi.models.ContentFormat;

public class BookFormatter {
    private ContentFormatter contentFormatter;

    public BookFormatter(ContentFormatter contentFormatter) {
        this.contentFormatter = contentFormatter;
    }

    public ContentFormat format(String request) {
        return contentFormatter.format(request);
    }
}
