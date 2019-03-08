package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author 孙继峰
 * @date 2018/12/02
 */
public interface FollowMapper {
    
    /**
     * 添加一个粉丝, authorId 与 userId 没有作外键关联, 需要提前验证
     * @param authorId 被粉的用户 id
     * @param userId 粉丝 id
     * @return 返回此操作影响数据库的列数
     */
    public Integer save(@Param("authorId") Integer authorId, @Param("userId") Integer userId);
    
    /**
     * 返回一个作者用户下的粉丝 id 集合
     * @param authorId 作者用户 id
     * @return 返回一个作者用户下的粉丝集合, 如果没有任何粉丝则返回空集合
     */
    public List<Integer> listFollower(Integer authorId);
    
    /**
     * 返回一个用户关注的作者 id 集合, 当用户不存在或没有任何关注返回空集合
     * @param userId 作者用户 id
     * @return 返回一个用户关注的作者集合
     */
    public List<Integer> listFollowing(Integer userId);
    
    /**
     * 取消关注
     * @param userId 粉丝 id
     * @param authorId 被取消关注的作者用户 id
     * @return 返回此操作影响数据库的列数
     */
    public Integer remove(@Param("userId") Integer userId, @Param("authorId") Integer authorId);
}
