package top.realdoer.entity;

import java.sql.Date;
import java.util.List;



import lombok.Data;
import top.realdoer.constant.FileTypeEnum;
import top.realdoer.constant.ItemType;

/**
 *  项目服务端模型 
 */
@Data
public abstract class Item {
    
    private Integer itemId;
    
    // 作者唯一标识
//    @NotNull(message="参数不能为空: authorId")
    private Integer authorId;
    
    // 项目标题
//    @NotBlank(message="参数不能为空: title")
//    @Length()
    private String title;
    
    // 项目描述
//    @NotBlank(message="参数不能为空: description")
    private String description;
    
    // 缩略图
//    @Length(max=255, message="缩略图名称过长")
    private String thumbnail;
    
    // 预览图
//    @Length(max=255, message="预览图名称过长")
    private String preview;
    
    // 主文件
//    @Length(max=255, message="主文件名称过长")
    private String mainFile;
    
    // 上传日期
//    @NotNull(message="参数不能为空: releaseDate")
    private Date releaseDate;
    
    // 最后更新日期
//    @NotNull(message="参数不能为空: lastUpdate")
    private Date lastUpdate;
    
    // 销量
//    @DecimalMax("32767")
    private Short sales;
    
    // 常规许可证版本售价
//    @DecimalMax("32767")
    private Short regularLicensePrice;
    
    // 扩展许可证版本售价
//    @DecimalMax("32767")
    private Short extendedLicensePrice;
    
    // 项目评分
//    @NotNull
    private Rate rate;
    
    // 项目类型
//    @NotNull
    private ItemType type;
    
    // 项目特点
//    @Size(max=3)
    private List<String> feature;
    
    // 项目标签
//    @Size(max=10)
    private List<String> tag;
    
    // 文件包含
//    @Size(max=10)
    private List<FileTypeEnum> fileInclude;
}