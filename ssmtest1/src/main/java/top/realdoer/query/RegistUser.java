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
    @NotBlank
    String username;
    @NotBlank
    String phone;
    @NotBlank
    String verificationCode;
    @NotBlank
    String password;
}
