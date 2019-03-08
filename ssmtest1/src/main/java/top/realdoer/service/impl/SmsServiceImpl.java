package top.realdoer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.realdoer.exception.ExternalAPIException;
import top.realdoer.sdk.juhe.JuheSms;
import top.realdoer.service.SmsService;

/**
 * @author 孙继峰
 * @date 2019年2月16日
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    /**
     * 聚合短信 api 实现
     */
    JuheSms sms;
    
    @Override
    public void sendLoginSms(String verificationCode, String phone) throws ExternalAPIException {
        sms.sendLoginSms(phone, verificationCode);
    }

    @Override
    public void sendRegistSms(String verificationCode, String phone) throws ExternalAPIException {
        sms.sendRegistSms(phone, verificationCode);
    }
}