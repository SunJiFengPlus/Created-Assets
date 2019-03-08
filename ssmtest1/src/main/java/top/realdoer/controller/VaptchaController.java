package top.realdoer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;
import top.realdoer.sdk.vaptcha.Entity;
import top.realdoer.sdk.vaptcha.Vaptcha;
import top.realdoer.sdk.vaptcha.VaptchaConfig;

/**
 * @author 孙继峰
 * @date 2019年2月15日
 */
@RestController
public class VaptchaController {
    private Vaptcha vaptcha = new Vaptcha(VaptchaConfig.VID,VaptchaConfig.KEY);

    @GetMapping("/vaptcha")
    public String getVaptcha(){
        String challenge = vaptcha.getChallenge(null);
        return challenge;
    }

    @PostMapping("/vaptcha-down")
    public String getDownTime(String data){
        String dowTime = vaptcha.downTime(data);
        System.out.println(dowTime);
        return dowTime;
    }

    /**
     * 获取用户的请求
     * @param entity(challenge,token)
     * 这里前端是通过formdata的数据发送的，所以接受参数的时候可以不用注解
     * 如果是payload里面需要用@requestBody的方式接收，写过springmvc都知道吧
     * @return
     */
//    @PostMapping("/login")
    // TODO: 与登陆模块耦合
    public String login(Entity entity){
        Boolean status = vaptcha.validate(entity.getChallenge(),entity.getToken(),null);
        if(status){
            return "success";
        }else {
            return "faild";
        }
    }
}
