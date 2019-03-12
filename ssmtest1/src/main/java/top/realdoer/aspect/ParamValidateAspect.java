package top.realdoer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import top.realdoer.constant.ResultEnum;
import top.realdoer.exception.ParamErrorException;

/**
 * 参数验证切面
 * @author 孙继峰
 * @date 2019/03/12
 */
@Aspect
@Order(1)
@Component
public class ParamValidateAspect {
    /**
     * 参数验证, 切入 controller 中参数包含 BindingResult 的方法, 切入时 BindingResult 以被赋值
     */
    @Before("execution(* top.realdoer.controller..*(.., org.springframework.validation.BindingResult,..))")
    public void before(JoinPoint point) throws ParamErrorException {
        // 获得切入方法参数
        Object[] args = point.getArgs();

        for (Object arg: args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    throw new ParamErrorException(ResultEnum.PARAM_INCORRECT);
                }
            }
        }
    }
}