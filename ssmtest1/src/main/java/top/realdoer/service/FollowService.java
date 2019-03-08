package top.realdoer.service;

import java.util.List;

import top.realdoer.exception.ServiceException;

/**
 * 关注/粉丝 Service
 * @param <E> 返回集合数据传输对象类型
 */
public interface FollowService {
    
    /**
     * 添加一个粉丝
     * @param authorId 被粉的作者用户 id
     * @param userId 粉丝 id
     * @return 返回此操作影响数据库的列数
     */
    public Integer saveFollower(Integer authorId, Integer userId) throws ServiceException;
    
    /**
     * 返回一个作者用户下的粉丝集合
     * @param authorId 作者用户 id
     * @return 返回一个作者用户下的粉丝集合
     */
    public List<Integer> listFollower(Integer authorId) throws ServiceException;
    
    /**
     * 返回一个用户关注的作者集合
     * @param userId 作者用户 id
     * @return 返回一个用户关注的作者集合
     */
    public List<Integer> listFollowing(Integer userId) throws ServiceException;
    
    /**
     * 取消关注
     * @param userId 粉丝 id
     * @param authorId 被取消关注的作者用户 id
     * @return 返回此操作影响数据库的列数
     */
    public Integer unfollow(Integer userId, Integer authorId) throws ServiceException;
}
