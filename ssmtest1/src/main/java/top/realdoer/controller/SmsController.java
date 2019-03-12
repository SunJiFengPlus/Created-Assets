package top.realdoer.controller;


import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import top.realdoer.constant.ResultEnum;
import top.realdoer.dto.Result;
import top.realdoer.exception.ExternalAPIException;
import top.realdoer.service.SmsService;
import top.realdoer.util.VerifyCodeUtil;

/**
 * @author 孙继峰
 * @date 2019年2月12日
 * TODO: 限制同一用户两次请求间隔时间 AOP/Interceptor
 * TODO: 以构造方法的方式来使用 Autowired 注解
 */
@RestController
public class SmsController {
    @Autowired
    private SmsService sms;
    /**
     *  Session 中验证码的 Key
     */
    static final String VER_CODE_KEY = "verificationCode";

    @GetMapping("/sms-login/{phone}")
    public Result sendLoginSms(@PathVariable("phone") @NotNull String phone, BindingResult result,
                               HttpSession session) throws ExternalAPIException {
        String verificationCode = VerifyCodeUtil.generateVerCode();
        session.setAttribute(VER_CODE_KEY, verificationCode);
        sms.sendLoginSms(verificationCode, phone);
        
        return new Result.Builder()
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
    
    @GetMapping("/sms-regist/{phone}")
    public Result sendRegisterSms(@PathVariable("phone") @NotNull String phone, BindingResult result,
                                  HttpSession session) throws ExternalAPIException {
        String verificationCode =  VerifyCodeUtil.generateVerCode();
        session.setAttribute(VER_CODE_KEY, verificationCode);
        System.out.println(verificationCode);
        sms.sendRegistSms(verificationCode, phone);
        
        return new Result.Builder()
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
}