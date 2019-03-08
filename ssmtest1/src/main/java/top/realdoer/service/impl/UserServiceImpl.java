package top.realdoer.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.realdoer.constant.ResultEnum;
import top.realdoer.dao.FollowMapper;
import top.realdoer.dao.UserMapper;
import top.realdoer.entity.User;
import top.realdoer.exception.ServiceException;
import top.realdoer.service.UserService;
import top.realdoer.util.RegexUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    FollowMapper followMapper;
    
    @Override
    public Integer saveUser(User user) throws ServiceException {
        if (userMapper.existUserName(user.getUsername())) {
            throw new ServiceException(ResultEnum.USERNAME_REGISTERED);
        }
        if (userMapper.existPhone(user.getPhone())) {
            throw new ServiceException(ResultEnum.PHONE_REGISTERED);
        }
        userMapper.save(user);
        return user.getUserId();
    }
    
    @Override
    public Integer removeUser(Integer userId) throws ServiceException {
        return userMapper.remove(userId);
    }

    // TODO: 目前全部是明文传输, 待修改
    @Override
    public Integer login(String phone, String onstagePassword) throws ServiceException {
        if (!RegexUtil.match(RegexUtil.PHONE, phone)) {
            throw new ServiceException(ResultEnum.LOGIN_ERROR);
        }
        User dbUser = userMapper.getUserByPhone(phone);
        if (dbUser != null) {
            if(onstagePassword.equals(dbUser.getPassword())) {
                return dbUser.getUserId();
            }
        }
        throw new ServiceException(ResultEnum.LOGIN_ERROR);
    }

    @Override
    public List<User> listFollower(Integer authorId) throws ServiceException {
        if (!userMapper.existUser(authorId)) {
            throw new ServiceException(ResultEnum.USER_DOESNT_EXIST);
        }
        List<Integer> ids = followMapper.listFollower(authorId);
        return userMapper.listUser(ids);
    }

    @Override
    public List<User> listFollowing(Integer userId) throws ServiceException {
        if (!userMapper.existUser(userId)) {
            throw new ServiceException(ResultEnum.USER_DOESNT_EXIST);
        }
        List<Integer> ids = followMapper.listFollowing(userId);
        if (ids.size() == 0) {
            return new ArrayList<User>();
        }
        return userMapper.listUser(ids);
    }

    @Override
    public User getUser(Integer userId) throws ServiceException {
        User user = userMapper.get(userId);
        if (user == null) {
            throw new ServiceException(ResultEnum.USER_DOESNT_EXIST);
        }
        return user;
    }
}
