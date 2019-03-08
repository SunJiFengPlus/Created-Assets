package top.realdoer.exception;

import lombok.Getter;
import top.realdoer.constant.ResultEnum;

/**
 * Service 层执行异常
 * @author 孙继峰
 * @date 2018/12/05
 */
@Getter
public class ServiceException extends Exception {
    private static final long serialVersionUID = -2011970468513496492L;
    private ResultEnum result;
     
    public ServiceException() {
        super();
    }

    public ServiceException(ResultEnum result) { 
        this.result = result;
    }
}
