package ru.unn.internetveshey.utils;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.lang.reflect.Field;

public class CommonEnumSerializer extends JsonSerializer<Enum<?>> {
    @Override
    public void serialize(Enum<?> object, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();

        try {
            generator.writeStringField("enumName", object.name());

            Field valueField = object.getClass().getDeclaredField("name");
            valueField.setAccessible(true);

            Object value = valueField.get(object);

            if (value != null) {
                generator.writeStringField(valueField.getName(), value.toString());
            } else {
                generator.writeNullField(valueField.getName());
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        generator.writeEndObject();
    }
}