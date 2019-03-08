package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.realdoer.constant.BrowerEnum;

/**
 *  兼容浏览器 
 *  TODO: 统一命名
 */
public interface CompatibleBrowerMapper {
    /**
     * 添加一个浏览器, webTemplateId 需要提前验证是否存在
     * @param webTemplateId 网站模板项目 id
     * @param browerEnum 浏览器枚举值
     * @return 返回此操作影响数据库的列数
     */
    public Integer save(@Param("webTemplateId") Integer webTemplateId, @Param("browerEnum") BrowerEnum browerEnum);
    
    /**
     * 添加一个浏览器集合, webTemplateId 需要提前验证是否存在
     * @param webTemplateId 网站模板项目 id
     * @param browerKeys 浏览器枚举值集合
     * @return 返回此操作影响数据库的列数
     */
    public Integer saveList(@Param("webTemplateId") Integer webTemplateId, @Param("browerKeys") List<BrowerEnum> browerKeys);
    
    /**
     * 返回一个网站模板项目中兼容浏览器集合
     * @param webTemplateItemId 网站模板项目 id
     * @return 返回一个网站模板项目中兼容浏览器集合, webTemplateId 不存在时, 返回空集合
     */
    public List<BrowerEnum> list(Integer webTemplateItemId);
}
