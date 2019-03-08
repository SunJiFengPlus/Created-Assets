package top.realdoer.constant;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 执行结果, 各种执行错误的信息需要添加到这里
 * @author 孙继峰
 * @date 2019/01/14
 */
public enum ResultEnum {
    
    SUCCESS(0, "Success"),
    
    PARAM_INCORRECT(1000,"参数不正确"),
    
    NOT_A_TOKEN(2000, "不是一个鉴权信息"),TOKEN_NOT_AVAILABLE(2001, "不是一个有效的鉴权信息"),
    SIGNATURE_VERIFICATION_FAILED(2002, "签名验证失败"), EXPIRED_TOKEN(2003, "过期的鉴权信息"),
    EMPTY_TOKEN(2004, "鉴权参数错误"),
    
    ITEM_DOESNT_EXIST(3000, "项目不存在"), USER_DOESNT_EXIST(3001, "用户不存在"),
    NO_AUTHORITY(3002, "没有执行权限"),
    
    USERNAME_REGISTERED(4000, "用户名已注册"), PHONE_REGISTERED(4001, "该手机已注册"),
    LOGIN_ERROR(4002, "用户名或密码错误"), VER_CODE_NOT_AVAILABLE(4003, "验证码错误"),
    
    DATABASE_ERROR(5000, "数据库执行错误"),
    
    EXTERNAL_API_ERROR(6000, "外部接口执行失败");
    
    private Integer resultCode;
    private String resultMessage;
    
    public Integer getResultCode() {
        return resultCode;
    }

    @JsonValue
    public String getResultMessage() {
        return resultMessage;
    }
    
    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    private ResultEnum(Integer errorCode,String errorMessage){
        this.resultCode = errorCode;
        this.resultMessage = errorMessage;
    }
}
