package top.realdoer.service;

import top.realdoer.exception.ServiceException;

/**
 * @author 孙继峰
 * @date 2018/12/1
 * @param <T> 操作对象类型
 */
public interface BaseService<T> {
    /**
     * 根据 id 获取对象
     * @param pk 主键值
     * @return 对象
     * @throws ServiceException
     */
    public T getById(Integer pk) throws ServiceException;
    
    /**
     * 保存对象
     * @param t 要保存的对象
     * @return 影响的列
     * @throws ServiceException 
     */
    public Integer save(T t) throws ServiceException;
    
    /**
     * 根据 id 删除对象
     * @param pk 主键值
     * @param opratorId 执行人的 id
     * @return 影响的列
     * @throws ServiceException 如果 executerId 没有执行权限则抛出 Service 层执行异常
     */
    public Integer removeById(Integer pk, Integer opratorId) throws ServiceException;
    
    /**
     * 更新对象
     * @param t 对象
     * @param opratorId 执行人的 id
     * @return 影响的列
     * @throws ServiceException 如果没有执行权限则抛出 Service 层执行异常
     */
    public Integer update(T t, Integer opratorId) throws ServiceException;
}