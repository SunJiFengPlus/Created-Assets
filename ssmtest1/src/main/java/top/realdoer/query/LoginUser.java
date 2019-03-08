package top.realdoer.query;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * controller 层接收前端登陆数据的模型
 * @author 孙继峰
 * @date 2019年2月17日
 */
@Data
@NotBlank
public class LoginUser {
    String phone;
    String password;
}
