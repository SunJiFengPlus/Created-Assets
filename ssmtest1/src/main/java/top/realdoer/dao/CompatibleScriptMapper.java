package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.realdoer.constant.ScriptEnum;

/**
 * @author 孙继峰
 * @date 2018/12/02
 */
public interface CompatibleScriptMapper {
    /**
     * 添加一个浏览器, webTemplateId 未作外键关联, 需要提前验证是否存在
     * @param webTemplateId 网站模板项目 id
     * @param browerEnum 浏览器枚举值
     * @return 返回此操作影响数据库的列数
     */
    public Integer save(@Param("webTemplateId") Integer webTemplateId,
                        @Param("scriptEnum") ScriptEnum scriptEnum);
    
    /**
     * 添加一个浏览器集合
     * @param webTemplateId 网站模板项目 id
     * @param browerKeys 浏览器枚举值集合
     * @return 返回此操作影响数据库的列数
     */
    public Integer saveList(@Param("webTemplateId") Integer webTemplateId,
                            @Param("scriptEnums") List<ScriptEnum> scriptEnums);
    
    /**
     * 返回一个网站模板项目中兼容浏览器集合
     * @param webTemplateItemId 网站模板项目 id
     * @return 返回一个网站模板项目中兼容浏览器集合, 当项目不存在时, 返回空集合
     */
    public List<ScriptEnum> list(Integer webTemplateItemId);
}
