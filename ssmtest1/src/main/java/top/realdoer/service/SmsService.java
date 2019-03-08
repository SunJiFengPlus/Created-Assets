package top.realdoer.service;

import top.realdoer.exception.ExternalAPIException;

/**
 * @author 孙继峰
 * @date 2019年2月12日
 */
public interface SmsService {
    /**
     * 发送登陆验证短信
     * @param verificationCode 验证码
     * @param phone 电话号
     */
    public void sendLoginSms(String verificationCode, String phone) throws ExternalAPIException;
    
    /**
     * 发送注册验证短信
     * @param verificationCode 验证码
     * @param phone 电话号
     */
    public void sendRegistSms(String verificationCode, String phone) throws ExternalAPIException;
}