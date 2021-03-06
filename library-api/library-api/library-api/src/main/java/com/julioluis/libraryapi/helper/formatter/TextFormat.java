package com.julioluis.libraryapi.helper.formatter;

import com.julioluis.libraryapi.models.ContentFormat;
import org.springframework.http.MediaType;

public class TextFormat implements ContentFormatter {
    @Override
    public ContentFormat format(String request) {
        ContentFormat contentFormat=new ContentFormat();
        contentFormat.setContent(request);
        contentFormat.setMediaType(MediaType.TEXT_PLAIN);
        return contentFormat;
    }
}
