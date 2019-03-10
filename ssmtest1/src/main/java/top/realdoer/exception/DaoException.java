package top.realdoer.exception;

import lombok.Getter;
import top.realdoer.constant.ResultEnum;

import java.sql.SQLException;

/**
 * @author 孙继峰
 * @date 2019/03/09
 */
@Getter
public class DaoException extends SQLException {
    private ResultEnum result;
    public DaoException(ResultEnum result) {
        this.result = result;
    }

    public DaoException(String message) {
        ResultEnum resultEnum = ResultEnum.DATABASE_ERROR;
        resultEnum.setResultMessage(message);
        this.result = resultEnum;
    }

    public DaoException(ResultEnum result, Throwable e) {
        super(e);
        this.result = result;
    }
}
