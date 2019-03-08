package top.realdoer.service;

import java.util.List;

import top.realdoer.entity.User;
import top.realdoer.exception.ServiceException;

public interface UserService {
    /**
     * 用户注册
     * @param user 用户对象
     * @return 新增数据对应的主键值
     * @exception ServiceException 当用户的手机号与用户名任意一个已经存在于或为 null 都会抛出异常
     */
    public Integer saveUser(User user) throws ServiceException;
    
    /**
     * 删除一个用户
     * TODO: tigger 删除用户把用户上传的项目删除, 需要管理员权限, 但我并不打算作管理员........
     * @param userId 用户 id
     * @return 
     */
    public Integer removeUser(Integer userId) throws ServiceException;
    
    /**
     * 用户登陆验证
     * @param phone 手机号
     * @param onstagePassword 前端传入密码
     * @return 当验证成功时返回用户 id
     * @throws ServiceException 当验证失败时抛出
     */
    public Integer login(String phone, String onstagePassword) throws ServiceException;

    /**
     * 返回作者用户下的粉丝
     * @param authorId 作者用户
     * @return 返回作者用户下的粉丝
     * @throws ServiceException 当 authorId 为null 或 authorId 不存在于数据库中抛出
     */
    public List<User> listFollower(Integer authorId) throws ServiceException;
    
    /**
     * 返回用户关注作者的集合
     * @param userId 用户 id
     * @return 如果此用户有关注任何作者则返回作者的集合, 否则返回空集合
     * @throws ServiceException 当 userId 为 null 时, 或者 userId 不存在于数据库中时抛出
     */
    public List<User> listFollowing(Integer userId) throws ServiceException;
    
    /**
     * 根据用户 id 返回用户
     * @param userId 用户 id
     * @return 返回用户 对象
     * @throws ServiceException 当 userId 不存在或 userId 为 null 时抛出
     */
    public User getUser(Integer userId) throws ServiceException;
}
