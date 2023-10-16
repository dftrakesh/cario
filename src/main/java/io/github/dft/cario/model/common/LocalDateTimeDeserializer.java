package io.github.dft.cario.model.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    @SneakyThrows
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) {
        String dateStr = parser.getText();
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
    }
}