package com.julioluis.libraryapi.helper.formatter;

public enum FormatType {
    HTML,PLAIN,PDF;

    public static FormatType getType(String format) {
        for (FormatType type : FormatType.values()) {
            if(type.toString().equalsIgnoreCase(format)) return type;
        }
        return PLAIN;
    }
}
