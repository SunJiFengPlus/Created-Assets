package top.realdoer.dao;

import java.util.List;

import top.realdoer.entity.TemplateHtml;
import top.realdoer.query.ItemFilter;

/**
 *  网站模板项目 
 */
public interface TemplateHtmlMapper extends BaseMapper<TemplateHtml> {
    
    /**
     * 返回符合过滤要求的项目集合, 传入 null 时抛出异常
     * @param filter 过滤条件
     * @return 返回符合过滤要求的项目集合
     */
    public List<TemplateHtml> listByFilter(ItemFilter filter);
    
    @Deprecated
    public Integer getAuthorId(Integer itemId);
}
