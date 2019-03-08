package top.realdoer.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 鉴权切面
 * @author 孙继峰
 * @date 2019/01/21
 */
@Aspect
//@Component
@Order(1)
public class AuthorizationAspect {
    
}
