package top.realdoer.interceptor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * API 参数验证拦截器 TODO: 测试: 在需要进行参数验证的方法上加上 BindingResult 参数, 猜测该参数有值
 * 
 * @author 孙继峰
 * @date 2019/01/19
 */
public class ParamValidateInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 请求中controller的方法名
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 解析handlermethod
        // 获取方法名
        String methodName = handlerMethod.getMethod().getName();
        // 获取类名,simplename是获取名字不带包名，name是带包名的
        String className = handlerMethod.getBean().getClass().getSimpleName();
        // 解析参数
        StringBuffer stringBuffer = new StringBuffer();
        Map paramMap = request.getParameterMap();
        Iterator it = paramMap.entrySet().iterator();
        while ((it.hasNext())) {
            Map.Entry entry = (Map.Entry) it.next();
            String mapKey = (String) entry.getKey();
            String mapValue = "";
            // request的这个参数map的value返回的是一个String[]
            Object obj = entry.getValue();
            if (obj instanceof String[]) {
                String[] strs = (String[]) obj;
                mapValue = Arrays.toString(strs);
            }
            stringBuffer.append(mapKey).append("=").append(mapValue);
        }
        return true;
    }
}
