package top.realdoer.exception;

import lombok.Getter;
import top.realdoer.constant.ResultEnum;

/**
 * 参数错误
 * @author 孙继峰
 * @date 2018/12/05
 */
@Getter
public class ParamErrorException extends Exception {
    private static final long serialVersionUID = -8258943016262270511L;
    private ResultEnum result;
     
    public ParamErrorException(String message) {
        super(message);
    }

    public ParamErrorException(ResultEnum result) { 
        this.result = result;
    }
}