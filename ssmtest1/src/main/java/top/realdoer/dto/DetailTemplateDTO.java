package top.realdoer.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;
import top.realdoer.constant.BrowerEnum;
import top.realdoer.constant.FileTypeEnum;
import top.realdoer.constant.ScriptEnum;
import top.realdoer.entity.Rate;

/**
 * 细节状态 Web 模板数据传输对象
 * @author 孙继峰
 * @date 2018/12/08
 */
@Data
public class DetailTemplateDTO {
    
    private Integer itemId;
    // 作者唯一标识
    private Integer authorId;
    // 项目标题
    private String title;
    // 项目描述
    private String description;
    // 预览图
    private String preview;
    // 上传日期
    private Date releaseDate;
    // 最后更新日期
    private Date lastUpdate;
    // 销量
    private Short sales;
    // 常规许可证版本售价
    private Short regularLicensePrice;
    // 扩展许可证版本售价
    private Short extendedLicensePrice;
    // 项目评分
    private Rate rate;
    // 项目标签
    private List<String> tag;
    // 文件包含
    private List<FileTypeEnum> fileInclude;
    // 示例链接
    private String demoUrl;
    // 兼容浏览器的枚举值集合
    private List<BrowerEnum> compatibleBrower;
    // 兼容插件的枚举值集合
    private List<ScriptEnum> compatibleScript;
}
