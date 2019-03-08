package top.realdoer.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

/**
 * 预览状态 Web 模板数据传输对象
 * @author 孙继峰
 * @date 2018/12/08
 */
@Data
public class PreviewTemplateDTO {
    
    private Integer itemId;
    // 作者名字
    private String authorName;
    // 项目标题
    private String title;
    // 预览图 
    private String preview;
    // 最后更新日期
    private Date lastUpdate;
    // 常规许可证版本售价 
    private Short regularLicensePrice;
    // 项目特点 
    private List<String> feature;
    // 项目标签
    private List<String> tag;
}
