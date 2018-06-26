package com.babich.httpwebserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ResourceReader resourceReader;
    private int port;
    String webAppPath;

    public void start() throws IOException {
        try (ServerSocket server = new ServerSocket(port)) {
            // когда клиент пытаеться присоединиться, метод аксепт возвращает сокет -> соединение с клиентом
            while (true) {
                try (Socket socket = server.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedOutputStream writer = new BufferedOutputStream((socket.getOutputStream()))
                ) {
                    RequestHandler requestHandler = new RequestHandler();
                    requestHandler.setReader(reader);
                    requestHandler.setWriter(writer);
                    requestHandler.setResourcePath(webAppPath);
                    requestHandler.handle();
                }
            }
        }
    }

    public void setResourceReader(ResourceReader resourceReader) {
        this.resourceReader = resourceReader;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }
}