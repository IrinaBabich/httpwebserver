package com.babich.httpwebserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ResourceReader resourceReader;
    private int port;
    String resourcePath;

    public void start() throws IOException {
        try (ServerSocket server = new ServerSocket(port)) {
            // когда клиент пытаеться присоединиться, метод аксепт возвращает сокет -> соединение с клиентом
            while (true) {
                try (Socket socket = server.accept();
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    RequestHandler requestHandler = new RequestHandler();
                    requestHandler.setReader(reader);
                    requestHandler.setWriter(writer);
                    requestHandler.setResourcePath(resourceReader.getResourcePath());
                    requestHandler.handle();
                }
            }
        }
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setWebAppPath(String resource) {
        this.resourceReader = new ResourceReader(resource);
    }
}