package top.realdoer.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import top.realdoer.constant.ResultEnum;
import top.realdoer.dto.Result;
import top.realdoer.exception.AuthorizationException;
import top.realdoer.exception.ExternalAPIException;
import top.realdoer.exception.ParamErrorException;
import top.realdoer.exception.ServiceException;

/**
 * 全局异常处理器, 仅处理目标方法执行产生的异常, 不会处理拦截器中的异常
 *
 * @author 孙继峰
 * @date 2018/12/04
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * Service 层执行异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ ServiceException.class })
    public Result handleServiceException(ServiceException e) {
        return new Result.Builder()
                .buildResult(e.getResult())
                .build();
    }

    /**
     * DAO 层执行异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ DataAccessException.class })
    public Result handleDataAccessException(Exception e) {
        ResultEnum res = ResultEnum.DATABASE_ERROR;
        res.setResultMessage(res.getResultMessage() + ": " +  e.getCause().getMessage());
        return new Result.Builder()
                .buildResult(res)
                .build();
    }

    /**
     * 接口传入参数错误(参数不合法/参数为空/参数为空字符串)
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ParamErrorException.class })
    public Result handleParamErrorException(ParamErrorException e) {
        return new Result.Builder()
                .buildResult(e.getResult())
                .build();
    }

    /**
     * 鉴权信息错误
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({ AuthorizationException.class })
    public Result handleAuthorizationException(AuthorizationException e) {
        return new Result.Builder()
                .buildResult(e.getResult())
                .build();
    }

    /**
     * 外部 API 异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ ExternalAPIException.class })
    public Result handleExternalAPIException(ExternalAPIException e) {
        return new Result.Builder()
                .buildResult(e.getResult())
                .build();
    }
}