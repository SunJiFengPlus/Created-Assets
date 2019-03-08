package top.realdoer.query;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * controller 层接收前端注册数据的模型
 * @author 孙继峰
 * @date 2019年2月17日
 */
@Data
public class RegistUser {
    @NotBlank(message = "用户名不能为空")
    String username;
    @NotBlank(message = "电话号码不能为空")
    String phone;
    @NotBlank(message = "验证码不能为空")
    String verificationCode;
    @NotBlank(message = "密码不能为空")
    String password;
}
