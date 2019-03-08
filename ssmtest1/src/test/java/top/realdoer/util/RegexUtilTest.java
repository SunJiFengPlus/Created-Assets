package top.realdoer.util;

import org.junit.Test;

import io.jsonwebtoken.lang.Assert;
import top.realdoer.util.RegexUtil;

public class RegexUtilTest {
    
    @Test
    public void testPhone() {
        String phone1 = "15944376650";
        Assert.isTrue(RegexUtil.match(RegexUtil.PHONE, phone1));
        
        String phone2 = "13500912477";
        Assert.isTrue(RegexUtil.match(RegexUtil.PHONE, phone2));
        
        String phone3 = "+8615944376650";
        Assert.isTrue(!RegexUtil.match(RegexUtil.PHONE, phone3));
        
        String phone4 = "中文当然不行";
        Assert.isTrue(!RegexUtil.match(RegexUtil.PHONE, phone4));
    }
    
    @Test
    public void testUsername() {
        String username1 = "jblm";
        Assert.isTrue(RegexUtil.match(RegexUtil.USERNAME, username1));
        
        String username3 = "中文可是可以的";
        Assert.isTrue(RegexUtil.match(RegexUtil.USERNAME, username3));
        
        String username2 = "asd";
        Assert.isTrue(!RegexUtil.match(RegexUtil.USERNAME, username2));
    }
    
    @Test
    public void testPassword() {
        // 符号可以
        String password1 = "+_)(*&^%$#@!"; 
        Assert.isTrue(RegexUtil.match(RegexUtil.PASSWORD, password1));
        
        // 数字可以
        String password4 = "01234567890123456789";
        Assert.isTrue(RegexUtil.match(RegexUtil.PASSWORD, password4));
        
        // 中文可以
//        String password2 = "中文可以的";
//        Assert.isTrue(RegexUtil.match(RegexUtil.PASSWORD, password2));
        
        // 少于 6 位不可以
        String password3 = "asdd";
        Assert.isTrue(!RegexUtil.match(RegexUtil.PASSWORD, password3));
        
        // 多于 20 位不可以
        String password5 = "012345678901234567890";
        Assert.isTrue(!RegexUtil.match(RegexUtil.PASSWORD, password5));
        
        // 不可以有空格
        String password6 = "       ";
        Assert.isTrue(!RegexUtil.match(RegexUtil.PASSWORD, password6));
    }
}
