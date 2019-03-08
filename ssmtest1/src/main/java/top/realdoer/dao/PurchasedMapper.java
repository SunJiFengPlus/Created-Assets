package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 已购买
 * @author 孙继峰
 * @date 2019/01/19
 */
public interface PurchasedMapper {
    /**
     * 添加一条购买记录
     * @param userId 用户 id
     * @param itemId 项目 id
     * @return 返回此操作影响数据库的列数
     */
    public Integer save(Integer userId, Integer itemId);
    
    /**
     * 返回一个用户下购买项目 id 的集合
     * @param userId 用户 id
     * @return 返回一个用户下购买项目 id 的集合, 如果没有此用户或者用户没有购买过任何项目则返回空集合
     */
    public List<Integer> listPurchased(Integer userId);
    
    /**
     * 用户是否已经购买过一个项目
     * @param userId 用户 id
     * @param itemId 项目 id
     * @return 用户是否已经购买过一个项目
     */
    public Boolean isPurchased(@Param("userId") Integer userId, @Param("itemId") Integer itemId);
    
    /**
     * 退款/删除购买记录, 需要提前确认记录是否存在
     * @param userId 用户 id
     * @param itemId 项目 id
     */
    public void refund(@Param("userId") Integer userId, @Param("itemId") Integer itemId);
}
