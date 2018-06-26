package com.babich.httpwebserver;

import java.io.*;

public class RequestHandler {

    private BufferedOutputStream writer;
    private String resourcePath;
    private BufferedReader reader;

    public void handle() throws IOException {
        RequestParser requestParser = new RequestParser();
        ResourceReader resourceReader = new ResourceReader(resourcePath);
        ResponseWriter responseWriter = new ResponseWriter();
        resourceReader.setWebAppPath(resourcePath);
        responseWriter.setBufferedOutputStream(writer);
        Request request = requestParser.parseRequest(reader);
        String resourcePath = request.getUrl();
        try {
            InputStream inputStream = resourceReader.readContent(resourcePath);
            // если ответ ок, пишем контент в ответ
            responseWriter.writeSuccessResponse();
            responseWriter.writeContent(inputStream);
        }catch (FileNotFoundException e){
            // если файла нет, пишем not found
            responseWriter.writeNotFoundResponse();
        }
    }

    public void setWriter(BufferedOutputStream writer) {
        this.writer = writer;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}
