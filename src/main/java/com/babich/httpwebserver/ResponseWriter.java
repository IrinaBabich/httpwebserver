package com.babich.httpwebserver;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {

    BufferedWriter writer;

    public void writeSuccessResponse(String content) throws IOException {
        writer.write("HTTP/1.1 200 OK\n");
        writer.write("\n");// ny vot, peredaew content null
        writer.write(content);
        writer.flush();
    }

    public void writeNotFoundResponse() throws IOException{
        writer.write("HTTP/1.1 404 NotFound\n"); // Po4emy BadRequest esli NotFound?!
        writer.write("\n");
        writer.flush();
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }
}