package com.py.examples.io.pipe;

import java.io.*;

/**
 * @author panyi on 18-3-27.
 * @since V3.0.1
 */
public class PipeExample {
    public static void main(String[] args) throws Exception {
        PipedInputStream pi = new PipedInputStream();
        PipedOutputStream po = new PipedOutputStream(pi);
        DemoThead1 t1 = new DemoThead1(pi);
        DemoThead2 t2 = new DemoThead2(po);
        new Thread(t1).start();
        new Thread(t2).start();
    }

    public static class DemoThead1 implements Runnable {
        PipedInputStream pi;

        public DemoThead1(PipedInputStream pi) {
            this.pi = pi;
        }

        public void run() {
            try(InputStreamReader ir = new InputStreamReader(pi)) {

                BufferedReader br = new BufferedReader(ir);
                String msg;
                while (true) {
                    System.out.println("开始...");
                    msg = br.readLine();
                    System.out.println("收到消息：" + msg);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class DemoThead2 implements Runnable {
        PipedOutputStream po;

        public DemoThead2(PipedOutputStream po) {
            this.po = po;
        }

        public void run() {
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(po),5);
                PrintWriter pw = new PrintWriter(bw);
                for (int i = 0; i < 10; i++) {
                    System.out.println("发送消息");
                    pw.println("abcd-" + i);
                    bw.flush();
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
