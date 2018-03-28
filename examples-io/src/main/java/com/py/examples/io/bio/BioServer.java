package com.py.examples.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * BIO的服务端
 * @author panyi on 18-3-27.
 * @since V3.0.1
 */
public class BioServer {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true) {
                socket = ss.accept();
                InputStream inputStream = socket.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String msg;
                while ((msg = bufferedReader.readLine()) != null) {
                    System.out.println(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
