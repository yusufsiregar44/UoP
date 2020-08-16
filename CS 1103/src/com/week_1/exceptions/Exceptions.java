package com.week_1.exceptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * @author Yusuf
 *
 * This class is designed to test Java's Exception
 */
public class Exceptions {
    InputStream in = null;
    OutputStream out = null;
    String urlString;
    String fileString;
    URL link = null;
    Byte bytes = null;

    public Exceptions(String url, String file) {
        urlString = url;
        fileString = file;

        try {
            assert urlString != null;
            link = new URL(urlString);
            in = link.openStream();

            assert fileString != null;
            out = new FileOutputStream(file);

            copyStream(in, out);

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyStream(InputStream in, OutputStream out)
        throws IOException {
            int oneByte = in.read();
            while (oneByte >= 0) { // negative value indicates end-of-stream
                out.write(oneByte);
                oneByte = in.read();
             }
        }
}
