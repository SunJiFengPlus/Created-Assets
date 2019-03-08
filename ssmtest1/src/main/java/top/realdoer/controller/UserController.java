package top.realdoer.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import top.realdoer.constant.ResultEnum;
import top.realdoer.dto.Result;
import top.realdoer.entity.User;
import top.realdoer.exception.ParamErrorException;
import top.realdoer.exception.ServiceException;
import top.realdoer.query.LoginUser;
import top.realdoer.query.RegistUser;
import top.realdoer.service.UserService;
import top.realdoer.util.JWTUtil;

@RestController
public class UserController {
    // TODO: 完善文档注释
    // TODO: 统一参数验证
    
    @Autowired
    UserService userService;
    
    /**
     * 返回关注作者的用户集合
     * @param authorId 作者 id
     * @return 返回关注作者的用户集合 
     * @throws ServiceException service 层执行异常
     */
    @GetMapping("/follower/{authorId}")
    public Result listFollowerByAuthorId(@PathVariable("authorId")Integer authorId) throws ServiceException {
        List<User> followers = userService.listFollower(authorId);
        
        return new Result.Builder()
                .buildData(followers)
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
    
    /**
     * 返回用户关注的作者集合
     * @param userId 用户 id
     * @return 返回用户关注的作者集合
     * @throws ServiceException service 层执行异常
     */
    @GetMapping("/following/{userId}")
    public Result listFollowingByUserId(@PathVariable("userId")Integer userId) throws ServiceException {
        List<User> following = userService.listFollowing(userId);
        
        return new Result.Builder()
                .buildData(following)
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
    
    /**
     * 注册
     * @throws ServiceException service 层执行异常
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws ParamErrorException 
     * TODO: AOP 切入进行参数验证
     */
    @PostMapping("/register")
    public Result register(@Valid RegistUser registUser, BindingResult result, 
            HttpSession session) throws Exception {
        if (result.hasErrors()) {
            throw new ParamErrorException(ResultEnum.PARAM_INCORRECT);
        }
        String verificationCode = (String) session.getAttribute(SmsController.VER_CODE_KEY);
        if (verificationCode == null || !verificationCode.equals(registUser.getVerificationCode())) {
            throw new ParamErrorException(ResultEnum.VER_CODE_NOT_AVAILABLE);
        }
        
        User user = new User();
        BeanUtils.copyProperties(user, registUser);
        userService.saveUser(user);
        String token = JWTUtil.build(String.valueOf(user.getUserId()));
        
        return new Result.Builder()
                .buildToken(token)
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
    
    /**
     * 登陆
     * FIXME: 登陆逻辑错误导致密码不正确也会签发鉴权信息 (Service 层)
     * @return 序列化的数据传输对象
     * @throws ServiceException service 层执行异常
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginUser loginUser) throws Exception {
        User user = new User();
        BeanUtils.copyProperties(user, loginUser);
        Integer userId = userService.login(user.getPhone(), user.getPassword());
        String token = JWTUtil.build(String.valueOf(userId));
        
        return new Result.Builder()
                .buildToken(token)
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
}