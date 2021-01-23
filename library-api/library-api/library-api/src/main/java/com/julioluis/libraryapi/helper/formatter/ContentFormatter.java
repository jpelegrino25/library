package com.julioluis.libraryapi.helper.formatter;

import com.julioluis.libraryapi.models.ContentFormat;

import java.util.Map;

public interface ContentFormatter {
    ContentFormat format(String request);
}
