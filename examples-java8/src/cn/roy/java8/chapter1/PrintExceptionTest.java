package cn.roy.java8.chapter1;

import java.util.Optional;

/**
 * @author Roy
 */
public class PrintExceptionTest {
    public static void main(String[] args) {
        try {
            new PrintExceptionTest().fireException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void fireException(){
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            throw new BizException("没有找到匹配商品",e);
        }
    }
}
class BizException extends RuntimeException{
    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
