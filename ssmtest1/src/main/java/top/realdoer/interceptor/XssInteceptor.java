package top.realdoer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * XSS 拦截器
 * @author 孙继峰
 * @date 2019/01/19
 */
public class XssInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        if(RequestMethod.GET.equals(request.getMethod()) || 
                RequestMethod.DELETE.equals(request.getMethod()) ) {
            return true;
        }
        // TODO: XSS 处理
        return true;
    }
}
