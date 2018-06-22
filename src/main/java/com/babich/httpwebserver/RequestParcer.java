package com.babich.httpwebserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class RequestParcer {
    private Map<String, String> headers = new Map<>();
    private Request request = new Request;


    public Request parceRequest(BufferedReader reader) throws IOException {

        return request;
    }

    public void injectUrlAndMethod(Request request, String requestLine){


    }

    public void injectHeaders(Request request, BufferedReader reader) throws IOException {


    }
}
