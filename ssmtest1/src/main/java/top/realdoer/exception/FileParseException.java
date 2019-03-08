package top.realdoer.exception;

import lombok.Getter;
import top.realdoer.constant.ResultEnum;

/**
 * 文件解析异常
 * @author 孙继峰
 * @date 2018/12/31
 */
@Getter
public class FileParseException extends Exception {
    private static final long serialVersionUID = -4827696462201708830L;
    private ResultEnum result;
     
    public FileParseException(ResultEnum result, Throwable cause) { 
        super(cause);
        this.result = result;
    }
}