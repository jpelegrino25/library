package com.julioluis.libraryapi.utils;

import org.springframework.http.MediaType;

public enum MediaTypeEnum {
    HTML("html", MediaType.TEXT_HTML),
    PLAIN("text",MediaType.TEXT_PLAIN);

    MediaTypeEnum(String format,MediaType mediaType) {
        this.format=format;
        this.mediaType=mediaType;
    }
    private MediaType mediaType;
    private String format;

    public MediaType getMediaType() {
        return mediaType;
    }

    public String getFormat() {
        return format;
    }

    public static MediaTypeEnum getMediaType(String format) {
        for(MediaTypeEnum typeEnum: MediaTypeEnum.values()) {
            if(typeEnum.format.equalsIgnoreCase(format)) {
                return typeEnum;
            }
        }
        return null;
    }
}
