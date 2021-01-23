package com.julioluis.libraryapi.models;

import org.springframework.http.MediaType;

public class ContentFormat {

    private Object content;
    private MediaType mediaType;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
