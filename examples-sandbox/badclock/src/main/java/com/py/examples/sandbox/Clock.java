package com.py.examples.sandbox;

/**
 * @author panyi on 18-5-15.
 */
public abstract class Clock {
    /**
     * 状态检查
     */
    abstract void checkState();

    // 日期格式化
    private final java.text.SimpleDateFormat clockDateFormat
            = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 格式化日期对象为字符串
     *
     * @param date 日期对象
     * @return 日期格式化输出
     */
    final String formatDate(java.util.Date date) {
        return clockDateFormat.format(date);
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    final java.util.Date nowDate() {
        return new java.util.Date();
    }

    /**
     * 报告时间
     *
     * @return 报告时间
     */
    final String report() {
        checkState();
        return formatDate(nowDate());
    }

    /**
     * 延时一定的时间
     *
     * @throws InterruptedException 中断
     */
    abstract void delay() throws InterruptedException;

    /**
     * 循环播报时间
     */
    final void loopReport() throws InterruptedException {
        while (true) {
            try {
                System.out.println(report());
            } catch (Throwable cause) {
                cause.printStackTrace();
            }
            delay();
        }
    }
}
