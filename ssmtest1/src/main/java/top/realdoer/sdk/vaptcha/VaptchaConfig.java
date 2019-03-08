package top.realdoer.sdk.vaptcha;

public class VaptchaConfig {
    /// 测试环境验证单元ID
//    public static final String VID = "5c668b60fc650ebe542a9961";
    // 生产环境验证单元ID
    public static final String VID = "5bd3adb1fc650e01b427960b";
    
    /// 测试环境验证单元密钥
//    public static final String KEY = "35839d30fb414c2090a485edf2288932";
    /// 环境验证单元密钥
    public static final String KEY = "ab19c642e84c4eda97601e2d7918e417";
    
    /// SDK版本号
    public static final String Version = "1.0.0";
    /// SDK语言
    public static final String SdkLang = "java";
    /// VaptchaAPI Url
    public static final String ApiUrl = "http://api.vaptcha.com";
    /// 获取流水号 Url
    public static final String GetChallengeUrl = "/challenge";
    /// 验证 Url
    public static final String ValidateUrl = "/validate";
    /// 验证数量使用完
    public static final String RequestUsedUp = "0209";
    /// 宕机模式检验恢复时间185000ms
    public static final long DownTimeCheckTime = 185000;
    /// 宕机模式二次验证失效时间十分钟
    public static final long ValidatePassTime = 600000;
    /// 宕机模式请求失效的时间25秒
    public static final long RequestAbateTime = 250000;
    /// 宕机模式验证等待时间2秒
    public static final long ValidateWaitTime = 2000;
    /// 宕机模式保存通过数量最大值50000
    public static final int MaxLength = 50000;
    /// 验证图的后缀png
    public static final String PicPostfix = ".png";
    /// 宕机模式key路径
    public static final String PublicKeyPath = "http://down.vaptcha.com/publickey";
    /// 是否宕机路径
    public static final String IsDownPath = "http://down.vaptcha.com/isdown";
    /// 宕机模式图片路径
    public static final String DownTimePath = "downtime/";
}
