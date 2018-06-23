package com.babich.httpwebserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        String content = resourceReader.readContent(resourcePath);

        if(request.getHttpMethod().equals(HttpMethod.GET)) {
            responseWriter.writeSuccessResponse(content);
        } else {
            responseWriter.writeNotFoundResponse(content);
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


