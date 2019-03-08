package top.realdoer.service;

import java.util.List;

import top.realdoer.entity.Item;
import top.realdoer.exception.ServiceException;
import top.realdoer.query.ItemFilter;

/**
 * @author 孙继峰
 */
public interface ItemService {

    /**
     * 返回一个项目, 如果没有明确的项目类型时调用此方法, 会减慢查询速度
     */
    public Item getItem(Integer id) throws ServiceException;

    /**
     * 根据作者 id 返回该作者所有项目集
     * 
     * @param authorId 作者 id
     * @param filter 过滤条件
     * @return 返回该作者所有项目集, 如果作者没有上传任何项目则返回空集合
     * @throws ServiceException 当 authorId 为 null 或 authorId 不存在于数据库中时抛出 ServiceException
     */
    public List<Item> listPortfolio(Integer authorId, ItemFilter filter) throws ServiceException;
    
    /**
     * 删除项目
     * @param itemId 项目 id
     * @param opratorId 操作人 id
     * @throws ServiceException 当用户不存在/ 项目不存在/ 操作人没有权限时抛出
     */
    public void removeItem(Integer itemId, Integer opratorId) throws ServiceException;
}
