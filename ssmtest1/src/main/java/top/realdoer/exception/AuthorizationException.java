package top.realdoer.exception;

import lombok.Getter;
import top.realdoer.constant.ResultEnum;

/**
 * 鉴权信息异常
 * @author 孙继峰
 * @date 2018/12/05
 */
@Getter
public class AuthorizationException extends Exception {
    private static final long serialVersionUID = -4401061714226665784L;
    private ResultEnum result;
     
    public AuthorizationException(ResultEnum result) { 
        this.result = result;
    }
    
    public AuthorizationException(ResultEnum result, Throwable e) { 
        super(e);
        this.result = result;
    }
}