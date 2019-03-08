package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.realdoer.entity.User;

/**
 * @author 孙继峰
 * @date 2018/12/02
 */
public interface UserMapper extends BaseMapper<User> {    
    /**
     * 根据 userId 集合返回用户集合, 当 userIds 为 null 或者为空集合都或抛异常
     * @param userIds 用户 id 集合
     * @return 根据 userId 集合返回用户集合
     */
    public List<User> listUser(@Param("userIds") List<Integer> userIds);
    
    /**
     * 判断 userName 是否已经存在于数据库中
     * @param userName 用户名
     * @return 当存在时返回 true, 否则返回 false
     */
    public Boolean existUserName(String userName);
    
    /**
     * 判断 email 是否已经存在于数据库中
     * @param email 邮箱地址
     * @return 当存在时返回 true, 否则返回 false
     */
    public Boolean existEmail(String email);
    
    /**
     * 判断 phone 是否已经存在于数据库中
     * @param phone 手机号
     * @return 当存在时返回 treu, 否则返回 false
     */
    public Boolean existPhone(String phone);
    
    /**
     * 判断 userId 对应的行是否存在
     * @param userId 用户 id
     * @return 当存在时返回 treu, 否则返回 false
     */
    public Boolean existUser(Integer userId);
    
    /**
     * 根据手机号返回用户
     * @param phone 手机号
     * @return 根据手机号返回用户, 如果不存在于数据库中则返回 null
     */
    public User getUserByPhone(String phone);
    
    /**
     * 根据用户名返回用户
     * @param userName 用户名
     * @return 根据用户返回用户, 如果不存在于数据库中则返回 null
     */
    public User getUserByUserName(String userName);
}