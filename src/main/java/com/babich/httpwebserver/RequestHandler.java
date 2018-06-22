package com.babich.httpwebserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RequestHandler {

    private ResourceReader resourceReader;
    private BufferedReader reader;
    private BufferedWriter writer;

    public RequestHandler(ResourceReader resourceReader, BufferedReader reader, BufferedWriter writer) {
        this.resourceReader = resourceReader;
        this.reader = reader;
        this.writer = writer;
    }

    public void handle() throws IOException {





    }
}


