package com.babich.httpwebserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RequestHandler {

    String resourcePath;
    private BufferedReader reader;
    private BufferedWriter writer;

    public void handle() throws IOException {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.parseRequest(reader);
        ResourceReader resourceReader = new ResourceReader(resourcePath);
        ResponseWriter responseWriter = new ResponseWriter();
        responseWriter.setWriter(writer);
        resourceReader.setResourcePath(resourcePath);
        String resourcePath = request.getUrl();
        try {
            String content = resourceReader.readContent(resourcePath);
            // если ответ ок, пишем контент в ответ
            responseWriter.writeSuccessResponse(content);
        }catch (FileNotFoundException e){
            // если файла нет, пишем not found
            responseWriter.writeNotFoundResponse();
        }
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }
}
