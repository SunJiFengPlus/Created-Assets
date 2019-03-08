package top.realdoer.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import top.realdoer.constant.ResultEnum;
import top.realdoer.exception.AuthorizationException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import java.security.Key;
import java.util.Date;

/**
 * Java Json Web Token 工具类
 * @author 孙继峰
 * @date 2018/12/22
 */
public class JWTUtil {
    
    /**
     * 签发者
     */
    private static final String ISSUER = "realdoer.top";
    
    /**
     * 加解密类型
     */
    private static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS256;

    /**
     * 添加至HTTP HEAD中的前缀
     */
    private static final String PREFIX = "Bearer ";

    /**
     * 默认有效时间: 12小时, 单位毫秒
     */
    private static final Long DEFAULT_DURATION = 43200000L;

    /**
     * 密钥/用于生成密钥对象的字符串
     */
    private static final String SECRET_KEY = "realdoer.top789";

    /**
     * 密钥对象
     */
    private static final Key KEY;

    /**
     * 生成密钥
     */
    static {
        // 将密钥生成规则转换为字节数组
        byte[] bytes = Base64.decodeBase64(SECRET_KEY);
        KEY = new SecretKeySpec(bytes, ALGORITHM.getJcaName());
    }

    /**
     * 构建 token
     *
     * @param alg jwt 加密算法
     * @param key jwt 加密密钥
     * @param sub jwt 面向的用户
     * @param aud jwt 接收方
     * @param jti jwt 唯一身份标识
     * @param iss jwt 签发者
     * @param nbf jwt 生效日期时间
     * @param duration jwt 有效时间，单位: 毫秒
     * @return token
     */
    public static String build(SignatureAlgorithm alg, Key key, String sub, String aud, String jti, String iss,
            Date nbf, Long duration) {
        // jwt 的签发时间
        Date iat = new Date(System.currentTimeMillis());
        duration = (duration == null || duration < 0) ? DEFAULT_DURATION : duration;
        // jwt 的过期时间, 这个过期时间必须要大于签发时间
        Date exp = new Date(System.currentTimeMillis() + duration);

        // 生成 token
        String pureToken = Jwts.builder().signWith(alg, key).setSubject(sub).setAudience(aud).setId(jti).setIssuer(iss)
                .setNotBefore(nbf).setIssuedAt(iat).setExpiration(exp).compact();

        // 在JWT字符串前添加"Bearer "字符串，用于加入"Authorization"请求头
        return PREFIX + pureToken;
    }

    /**
     * 构建JWT
     * 
     * @param jti 唯一身份标识
     * @return 鉴权字符串
     */
    public static String build(String jti) {
        return build(ALGORITHM, KEY, null, null, jti, ISSUER, null, DEFAULT_DURATION);
    }
    
    /**
     * 得到 jwt 中 payload 的值 (payload 为 map 结构)
     * @param token http 请求中 Authorization 的内容 
     * @param key map 的 key
     * @return key 对应的 value
     * @throws AuthorizationException 解析失败或鉴权信息错误时
     */
    public static Object getPayloadDetail(String token, String key) throws AuthorizationException {
        Claims payload = parse(token);
        return payload.get(key);
    }
    
    /**
     * 得到 jwt 中 payload 的值 (payload 为 map 结构)
     * @param key map 的 key
     * @return key 对应的 value
     * @throws AuthorizationException 解析失败或鉴权信息错误时
     */
    public static Object getPayloadDetail(HttpServletRequest request, String key) throws AuthorizationException {
        Claims payload = parse(request.getHeader("Authorization"));
        return payload.get(key);
    }
    
    /**
     * 验证 token 是否有效
     * @param token 
     * @return token 有效/正确时返回 true, 否则 false
     * @throws AuthorizationException 解析失败或鉴权信息错误时
     */
    public static Boolean check(String token) throws AuthorizationException {
        Claims payload = parse(token);
        if(check(payload)) {
            return true;
        }
        return false;
    }
    
    /**
     * token 验证
     * @return token 有效/正确时返回 true, 否则 false
     */
    private static Boolean check(Claims payload) {
        // 过时验证
        if (new Date().after(payload.getExpiration())) {
            return false;
        }
        return true;
    }

    /**
     * 解析鉴权字符串
     * @param token 
     * @return 解析完成数据
     * @throws AuthorizationException 解析失败或鉴权信息错误时
     */
    private static Claims parse(String token) throws AuthorizationException {
        if ("".equals(token) || token == null) {
            throw new AuthorizationException(ResultEnum.NOT_A_TOKEN);
        }
        // 移除 JWT 前的 "Bearer " 字符串
        token = StringUtils.substringAfter(token, PREFIX);
        
        
        Jws<Claims> claims = null;
        // 解析 JWT 字符串
        try {
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
        } catch (MalformedJwtException e) {
            throw new AuthorizationException(ResultEnum.TOKEN_NOT_AVAILABLE, e.getCause());
        } catch (SignatureException e) {
            throw new AuthorizationException(ResultEnum.SIGNATURE_VERIFICATION_FAILED, e.getCause());
        } catch (ExpiredJwtException e) {
            throw new AuthorizationException(ResultEnum.EXPIRED_TOKEN, e.getCause());
        }
        return claims.getBody();
    }
}
