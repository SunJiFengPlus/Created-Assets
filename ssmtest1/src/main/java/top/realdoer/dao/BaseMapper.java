package top.realdoer.dao;

/**
 * @author 孙继峰
 * @date 2018/12/2
 * @param <T> 操作的数据类型
 */
public interface BaseMapper<T> {
    
    /**
     * 保存行
     * @param t 
     * @return 保存行
     */
    public Integer save(T t);
    
    /**
     * 删除行
     * @param pk 主键值
     * @return 影响的列
     */
    public Integer remove(Integer pk);
    
    /**
     * 更新行
     * @param t 
     * @return 影响的列
     */
    public Integer update(T t);
    
    /**
     * 返回行
     * @param pk 主键
     * @return 当 pk 对应的行存在时返回该对象, 否则返回 null
     */
    public T get(Integer pk);
}
