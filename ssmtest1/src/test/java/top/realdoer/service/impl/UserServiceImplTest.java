package top.realdoer.service.impl;


import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Assert;
import top.realdoer.dao.FollowMapper;
import top.realdoer.dao.UserMapper;
import top.realdoer.entity.User;
import top.realdoer.exception.ServiceException;
import top.realdoer.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Transactional
@Rollback
public class UserServiceImplTest {
    @Autowired
    UserService service;
    @Autowired
    UserMapper userMapper;
    @Autowired
    FollowMapper followMapper;
    
    @Test
    public void testSaveUser1() {
//        Boolean executed = false;
//        user.setUsername("jblm");
//        try {
//            service.saveUser(user);
//            executed = true;
//        } catch (ServiceException e) {
//            Assert.isTrue(e.getMessage().equals("用户名已存在"));
//        }
//        Assert.isTrue(!executed);
    }
    
    @Test
    public void testSaveUser2() {
//        Boolean executed = false;
//        user.setUsername("uniqueUserName");
//        user.setPhone("15944376650");
//        try {
//            service.saveUser(user);
//            executed = true;
//        } catch (ServiceException e) {
//            Assert.isTrue(e.getMessage().equals("该手机已注册"));
//        }
//        Assert.isTrue(!executed);
    }
    
    @Test
    public void testSaveUser3() {
//        user.setPassword("123");
//        user.setPhone("15944376659");
//        user.setUsername("uniqueUserName");
//        try {
//            service.saveUser(user);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        Assert.isTrue(userMapper.existPhone("15944376659"));
//        Assert.isTrue(userMapper.existUserName("uniqueUserName"));
//        removeUser();
    }
    
    @Test
    public void testRemove() {
//        saveUser();
//        Integer userId = user.getUserId();
//        try {
//            service.removeUser(userId);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        Assert.isTrue(!userMapper.existUser(userId));
    }
    
    @Test
    public void testLogin1() {
//        saveUser();
//        
//        Integer userId = null;
//        try {
//            userId = service.login("15944376659", "123");
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } finally {
//            removeUser();
//        }
//        Assert.isTrue(user.getUserId().equals(userId));
    }
    
    @Test
    public void testLogin2() {
//        saveUser();
//        
//        Integer userId = null;
//        try {
//            userId = service.login("1594437665995", "123");
//        } catch (ServiceException e) {
//            Assert.isTrue(e.getMessage().equals("用户名或密码错误"));
//        } finally {
//            removeUser();
//        }
//        Assert.isTrue(userId == null);
    }
    
    @Test
    public void testLogin3() {
//        saveUser();
//        
//        Integer userId = null;
//        try {
//            userId = service.login("15944376659", "1234");
//        } catch (ServiceException e) {
//            Assert.isTrue(e.getMessage().equals("用户名或密码错误"));
//        } finally {
//            removeUser();
//        }
//        Assert.isTrue(userId == null);
    }
    
    @Test
    public void testListFollower1() {
//        saveFollower();
//        
//        List<User> userList = null;
//        try {
//            userList = service.listFollower(1001);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } finally {
//            removeFollower();
//        }
//        Assert.notNull(userList);
//        Assert.isTrue(userList.size() == 4);
    }
    
    @Test
    public void testListFollower2() {
//        saveFollower();
//        
//        List<User> userList = null;
//        try {
//            userList = service.listFollower(100110);
//        } catch (ServiceException e) {
//            Assert.isTrue(e.getMessage().equals("用户不存在"));
//        } finally {
//            removeFollower();
//        }
//        Assert.isNull(userList);
    }
    
    @Test
    public void testListFollowing1() throws ServiceException {
        
        User user1 = new User();
        user1.setAvatar("https://realdoer.top/avatar");
        user1.setEmail("1471423@qq.com");
        user1.setPassword("123");
        user1.setPhone("159444");
        user1.setProfile("工作什么是不可能的, 代码也不会打, 只能靠偷偷电瓶车勉强维持生活");
        user1.setRegisterDate(new Date(System.currentTimeMillis()));
        user1.setUsername("asd");
        userMapper.save(user1);
        
        User user2 = new User();
        user2.setAvatar("https://realdoer.top/avatar");
        user2.setEmail("1471424@qq.com");
        user2.setPassword("123");
        user2.setPhone("159445");
        user2.setProfile("工作什么是不可能的, 代码也不会打, 只能靠偷偷电瓶车勉强维持生活");
        user2.setRegisterDate(new Date(System.currentTimeMillis()));
        user2.setUsername("asd");
        userMapper.save(user2);
        
        User user3 = new User();
        user3.setAvatar("https://realdoer.top/avatar");
        user3.setEmail("1471425@qq.com");
        user3.setPassword("123");
        user3.setPhone("159446");
        user3.setProfile("工作什么是不可能的, 代码也不会打, 只能靠偷偷电瓶车勉强维持生活");
        user3.setRegisterDate(new Date(System.currentTimeMillis()));
        user3.setUsername("asd");
        userMapper.save(user3);
        
        followMapper.save(user2.getUserId(), user1.getUserId());
        followMapper.save(user3.getUserId(), user1.getUserId());
        
        List<User> userList  = service.listFollowing(user1.getUserId());
        Assert.notNull(userList);
        Assert.isTrue(userList.size() == 2);
    }
    
    @Test
    public void testListFollowing2() {
//        saveFollower();
//        
//        List<User> userList = null;
//        try {
//            userList = service.listFollowing(100110);
//        } catch (ServiceException e) {
//            Assert.isTrue(e.getMessage().equals("用户不存在"));
//        } finally {
//            removeFollower();
//        }
//        Assert.isNull(userList);
    }
    
    @Test
    public void testGetUser1() {
//        saveUser();
//        
//        User temp = null;
//        try {
//            temp = service.getUser(user.getUserId());
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } finally {
//            removeUser();
//        }
//        Assert.notNull(temp);
//        Assert.isTrue(user.getPassword().equals(temp.getPassword()));
//        Assert.isTrue(user.getPhone().equals(temp.getPhone()));
//        Assert.isTrue(user.getUserId().equals(temp.getUserId()));
//        Assert.isTrue(user.getUsername().equals(temp.getUsername()));
    }
    
    @Test
    public void testGetUser2() {
//        User temp = null;
//        try {
//            temp = service.getUser(10100);
//        } catch (ServiceException e) {
//            Assert.isTrue(e.getMessage().equals("用户不存在"));
//        }
//        Assert.isNull(temp);
    }
    
    @Test
    public void testGetUser3() {
//        User temp = null;
//        try {
//            temp = service.getUser(null);
//        } catch (ServiceException e) {
//            Assert.isTrue(e.getMessage().equals("用户不存在"));
//        }
//        Assert.isNull(temp);
    }
}
