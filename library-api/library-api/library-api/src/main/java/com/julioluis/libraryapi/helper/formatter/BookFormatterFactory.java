package com.julioluis.libraryapi.helper.formatter;

import com.julioluis.libraryapi.models.ContentFormat;

public class BookFormatterFactory {

    public static ContentFormat getContentFormat(String format,String content) {
        FormatType formatType=FormatType.getType(format);
        BookFormatter bookFormatter=new BookFormatter(new TextFormat());

        switch (formatType) {
            case HTML:
                bookFormatter=new BookFormatter(new HtmlFormat());
                return bookFormatter.format(content);
            case PLAIN:
                bookFormatter=new BookFormatter(new TextFormat());
                return bookFormatter.format(content);

            default:
                return bookFormatter.format(content);
        }

    }
}
