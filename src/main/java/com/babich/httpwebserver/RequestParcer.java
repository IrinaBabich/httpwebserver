package com.babich.httpwebserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {
    private Request request = new Request();

    public Request parceRequest(BufferedReader reader) throws IOException {
        String requestLine = reader.readLine();
        Request request = new Request();
        injectUrlAndMethod(request, requestLine);
        return request;
    }

    public void injectUrlAndMethod(Request request, String requestLine) throws IOException{
        String[] split = requestLine.split(" ");
        request.setHttpMethod(split[0]);
        request.setUrl(split[1]);
    }

    public void injectHeaders(Request request, BufferedReader reader) throws IOException {
        Map<String, String> headers = new HashMap<>();

        while (reader.readLine() != null) {
            String headersLine = reader.readLine();
            String[] split = headersLine.split(" ");
            headers.put(split[0], split[1]);
            request.setHeaders(headers);
        }
    }
}
