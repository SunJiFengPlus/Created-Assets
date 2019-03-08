package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 *  收藏
 */
public interface FavoriteMapper {
    /**
     * 添加一条收藏记录, userId 与 itemId 未作外键关联, 插入时需要提前验证是否存在
     * @param userId 用户 id
     * @param itemId 项目 id
     * @return 返回此操作影响数据库的列数
     */
    public Integer save(@Param("userId") Integer userId, @Param("itemId") Integer itemId);
    
    /**
     * 返回一个用户下收藏的项目 id 集合
     * @param userId 用户 id
     * @return 返回一个用户下收藏的项目集合, 当 userId 不存在时返回空集合
     */
    public List<Integer> list(Integer userId);
    
    /**
     * 移除用户下的一项收藏
     * @param userId 用户 id
     * @param itemId 项目 id
     * @return 返回此操作影响数据库的列数
     */
    public Integer remove(@Param("userId") Integer userId, @Param("itemId") Integer itemId);
}
