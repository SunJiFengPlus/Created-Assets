package top.realdoer.util;

import org.junit.Test;

import io.jsonwebtoken.Claims;
import top.realdoer.exception.AuthorizationException;
import top.realdoer.util.JWTUtil;

public class JWTUtilTest {
    
    @Test
    public void testJWT() throws AuthorizationException {
        String token = JWTUtil.build("1001");
        System.out.println(token);
        String id = (String) JWTUtil.getPayloadDetail(token, Claims.ID);
        String issuer = (String) JWTUtil.getPayloadDetail(token, Claims.ISSUER);
        System.out.println(id);
        System.out.println(issuer);
    }
    
    @Test
    public void testJWT1() throws AuthorizationException {
        //System.out.println(JWTUtil.getPayloadDetail("Bearer asdasdasdaasdasdasd", Claims.ID));
    }
}