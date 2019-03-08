package top.realdoer.exception;

import lombok.Getter;
import top.realdoer.constant.ResultEnum;

/**
 * 外部 API 异常
 * @author 孙继峰
 * @date 2019年2月9日
 */
@Getter
public class ExternalAPIException extends Exception {
    // TODO: 第三方错误码映射为应用错误码
    private static final long serialVersionUID = 896348564389714749L;
    private ResultEnum result;

    public ExternalAPIException(ResultEnum result, Throwable cause) { 
        super(cause);
        this.result = result;
    }
    
    public ExternalAPIException(ResultEnum result) { 
        this.result = result;
    }
}
