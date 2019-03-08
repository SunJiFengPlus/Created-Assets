package top.realdoer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 孙继峰
 * @date 2019年2月10日
 */
public class RegexUtil {
    public static final String PHONE = "^1[3,4,5,7,8]\\d{9}$";
    public static final String USERNAME = "^[\\u4e00-\\u9fff\\w]{4,16}$";
    public static final String PASSWORD = "^[^\\s]{6,20}$";
    
    public static Boolean match(String regex, String target) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(target);
        return m.matches();
    }
}
