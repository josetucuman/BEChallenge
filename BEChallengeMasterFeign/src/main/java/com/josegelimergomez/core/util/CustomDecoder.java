package com.josegelimergomez.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josegelimergomez.core.dto.MovieResponse;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
public class CustomDecoder implements Decoder {

    @Autowired
    private ObjectMapper objectMapper;

    public CustomDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Object decode(Response response, Type type)
            throws IOException, DecodeException, FeignException {
        if (response.body() == null) {
            return null;
        }
        String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
        return objectMapper.readValue(bodyStr, objectMapper.constructType(type));
    }
}
