package top.realdoer.util;

import org.junit.Test;

import io.jsonwebtoken.lang.Assert;

public class VerifyCodeUtilTest {
    @Test
    public void test1() {
        for (int i=0; i<10000; i++) {
            String verCode = VerifyCodeUtil.generateVerCode();
            Assert.isTrue(verCode.length() == 6);
        }
    }
}
