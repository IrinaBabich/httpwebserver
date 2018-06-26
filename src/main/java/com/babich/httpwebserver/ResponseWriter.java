package com.babich.httpwebserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResponseWriter {

    private BufferedOutputStream bufferedOutputStream;

    public void writeContent(InputStream inputStream) throws IOException {
        int count;
        byte[] buffer = new byte[1024];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (((count = bufferedInputStream.read(buffer)) != -1)) {
            bufferedOutputStream.write(buffer, 0, count);
        }
        bufferedOutputStream.write("\r\n".getBytes());

    }

    public void writeSuccessResponse() throws IOException {
        bufferedOutputStream.write("HTTP/1.1 200 OK\n".getBytes());
        bufferedOutputStream.write("\r\n".getBytes());
    }

    public void writeNotFoundResponse() throws IOException{
        bufferedOutputStream.write("HTTP/1.1 404 NotFound\n".getBytes());
        bufferedOutputStream.write("\r\n".getBytes());
    }

    public void setBufferedOutputStream(BufferedOutputStream bufferedOutputStream) {
        this.bufferedOutputStream = bufferedOutputStream;
    }
}