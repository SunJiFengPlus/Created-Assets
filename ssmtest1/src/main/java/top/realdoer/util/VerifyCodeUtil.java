package top.realdoer.util;

import javax.xml.bind.annotation.XmlType;
import java.util.Random;

/**
 * 生成验证码
 * @author 孙继峰
 * @date 2019年3月6日
 */

public class VerifyCodeUtil {
    public static final int DEF_VER_CODE_LEN = 6;

    /**
     * 生成默认位数的验证码
     * @return 验证码
     */
    public static String generateVerCode() {
        StringBuffer verCode = new StringBuffer();
        Random random = new Random();
        for (int i=0; i<DEF_VER_CODE_LEN; i++) {
            verCode.append(random.nextInt(10));
        }
        return verCode.toString();
    }
}
