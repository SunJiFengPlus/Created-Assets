package top.realdoer.service;

import java.util.List;

import top.realdoer.entity.TemplateHtml;
import top.realdoer.exception.ServiceException;
import top.realdoer.query.ItemFilter;

public interface TemplateHtmlService extends BaseService<TemplateHtml> {
    // TODO: trigger 删除项目时把其他表中与此项目有关的东西删掉
    /**
     * 根据过滤条件返回 HTML 模板集合
     * @param filter 过滤条件
     * @return 根据过滤条件返回 HTML 模板集合
     * @throws ServiceException
     */
    public List<TemplateHtml> listByFilter(ItemFilter filter) throws ServiceException;
}
