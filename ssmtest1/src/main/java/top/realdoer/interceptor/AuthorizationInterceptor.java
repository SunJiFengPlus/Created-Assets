package top.realdoer.interceptor;

import top.realdoer.exception.AuthorizationException;
import top.realdoer.util.JWTUtil;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求鉴权拦截器, 用于检查鉴权信息是否正确, 判断登陆状态, 没有任何权限检查
 * 
 * @author 孙继峰
 * @date 2019/01/18
 */
@Deprecated
public class AuthorizationInterceptor implements HandlerInterceptor {

    /*
     * 如果某一个拦截器的 preHandle 方法返回 false, 整个请求结束, 其目标方法不会被调用, 其后的 interceptor 也不会被调用 
     * 实现测试会不会被全局异常处理其处理
     * TODO: 拦截器中抛出的异常不会被全局异常处理器处理, 需要把异常信息返回给前端
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取 HTTP HEAD 中的鉴权信息
        String token = request.getHeader("Authorization");

        try {
            JWTUtil.check(token);
        } catch (AuthorizationException e) {
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            try {
                response.getWriter();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
        // WrappedErrorDTO dto = new WrappedErrorDTO();
        // ObjectMapper mapper = new ObjectMapper();
        // mapper.
        return true;
    }

}