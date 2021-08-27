package com.github.ProjectBalashov;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Web{
    public static void main(String[] args){

    }
    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static ByteBuf toByteBuf(Object o) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            OBJECT_MAPPER.writeValue(out, o);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ByteBufAllocator.DEFAULT.buffer().writeBytes(out.toByteArray());
    }
}