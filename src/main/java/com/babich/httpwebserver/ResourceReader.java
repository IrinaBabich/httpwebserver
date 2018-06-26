package com.babich.httpwebserver;

import java.io.*;

public class ResourceReader {

    private String webAppPath;

    ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public InputStream readContent(String path) throws IOException {
        File resourcePath = new File(webAppPath + path);

        try  {
            return new FileInputStream(resourcePath);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }
}