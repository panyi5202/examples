package com.py.examples.io.bio;

import java.io.*;
import java.net.Socket;

/**
 * @author panyi on 18-3-27.
 * @since V3.0.1
 */
public class BioClient {
    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            // String str = "1245678901234567890123456770";

            InputStream in = System.in;
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String msg = "";
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println("发送：" + msg);
                printWriter.println(msg);
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
