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
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true) {
                // accept是阻塞方法，收到客户端请求才会继续往下执行
                Socket socket = ss.accept();
                // 这里可以使用线程池进行优化
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
    public static class SocketHandler implements Runnable{
        public Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String msg;
                while ((msg = bufferedReader.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
