package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author 孙继峰
 * @date 2018/12/02
 */
public interface CartMapper {
    /**
     * 添加至购物车, userId itemId 未作外键关联, 需要提前验证是否存在
     * @param userId 用户 id
     * @param itemId 项目 id
     * @return 此操作影响数据库的列数
     */
    public Integer save(@Param("userId") Integer userId, @Param("itemId") Integer itemId);
    
    /**
     * 返回购物车项目数
     * @param userId 用户 id
     * @return 购物车项目总数
     */
    public Integer count(Integer userId);

    /**
     * 返回购物车中项目 id 集合
     * @param userId 用户 id
     * @return 返回购物车中项目 id 集合
     */
    public List<Integer> list(Integer userId);
    
    /**
     * 从购物车中移除一个项目
     * @param userId 用户 id
     * @param itemId 项目 id
     * @return 返回此操作影响数据库的列数
     */
    public Integer remove(@Param("userId") Integer userId, @Param("itemId") Integer itemId);
    
    /**
     * 清空购物车
     * @param userId 用户 id
     * @return 此操作影响数据库的列数
     */
    public Integer removeAll(Integer userId);
}
