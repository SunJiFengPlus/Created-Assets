package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.realdoer.entity.Item;
import top.realdoer.query.ItemFilter;

/**
 * @author 孙继峰
 * @date 2018/12/2
 */
public interface ItemMapper {
    /**
     * 返回一个项目, 如果有明确的项目类型时不要调用此方法, 此方法相对消耗性能 
     * @param itemId 项目 id
     * @return 返回一个项目, 如果项目不存在则返回 null
     */
    public Item getItem(Integer itemId);

    /**
     * 返回一个作者下的全部项目, 当作者不存在时返回空集合
     * @param authorId 作者 id
     * @param filter 过滤参数
     * @return 返回一个作者下的全部项目, 当 filter 为 null 时抛出异常
     */
    public List<Item> listPortfolio(@Param("authorId") Integer authorId, @Param("filter") ItemFilter filter);
    
    /**
     * 根据 id 集合, 返回 项目集合
     * @param itemIds id 集合
     * @return 根据 id 集合, 返回 项目集合, 如果传入 null 或 itemIds 为空集合时抛出异常
     */
    public List<Item> listItem(@Param("itemIds") List<Integer> itemIds);
    
    /**
     * 根据 itemId 返回其对应的 authorId
     * @param itemId 项目 id
     * @return 根据 itemId 返回其对应的 authorId, 如果 itemId 不存在则返回 null
     */
    public Integer getAuthorId(Integer itemId);
    
    /**
     * 判断 itemId 对应的行是否存在
     * @param itemId 项目 id
     * @return 如果存在返回 true, 否则返回 false
     */
    public Boolean exist(Integer itemId);
    
    /**
     * 删除一个项目, 用户操作前需要判断项目是否属于此用户
     * @param itemId 项目 id
     */
    public void removeItem(Integer itemId);
}
