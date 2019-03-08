package top.realdoer.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author 孙继峰
 * @date 2019年2月10日
 */
public class IOUitl {
    public static void close(Closeable... objects) {
        for (Closeable object: objects) {
            if (object != null) {
                try {
                    object.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
