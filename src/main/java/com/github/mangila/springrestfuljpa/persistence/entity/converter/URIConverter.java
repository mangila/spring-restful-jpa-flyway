package com.github.mangila.springrestfuljpa.persistence.entity.converter;

import javax.persistence.Converter;
import javax.persistence.AttributeConverter;
import java.net.URI;

@Converter
public class URIConverter implements AttributeConverter<URI, String> {

    @Override
    public String convertToDatabaseColumn(URI uri) {
        return uri.toString();
    }

    @Override
    public URI convertToEntityAttribute(String uri) {
        return URI.create(uri);
    }
}
