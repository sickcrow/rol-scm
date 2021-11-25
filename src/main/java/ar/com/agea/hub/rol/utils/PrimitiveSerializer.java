package ar.com.agea.hub.rol.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ar.com.agea.hub.rol.model.dto.PrimitiveDTO;

public class PrimitiveSerializer extends JsonSerializer<Object> {
	public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
	   PrimitiveDTO<?> primitive = (PrimitiveDTO<?>) value;
	   
	   jgen.writeStartObject();
	   jgen.writeObjectField(primitive.getFieldName(), primitive.getValue());
	   jgen.writeEndObject();
	}
}
