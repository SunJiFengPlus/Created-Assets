package top.realdoer.dao;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Assert;
import top.realdoer.dao.UserMapper;
import top.realdoer.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class UserMapperTest {
    // TODO: 测试类 AIR 原则
    // TODO: 边界测试
    @Autowired
    UserMapper mapper;
    
    @Test
    public void testSave() {
        User user = new User();
        user.setAvatar("https://realdoer.top/avatar");
        user.setEmail("1471423@qq.com");
        user.setPassword("123");
        user.setPhone("159444");
        user.setProfile("工作什么是不可能的, 代码也不会打, 只能靠偷偷电瓶车勉强维持生活");
        user.setRegisterDate(new Date(System.currentTimeMillis()));
        user.setUsername("asd");
        
        Assert.isTrue(mapper.save(user).equals(1));
        Assert.notNull(user.getUserId());
    }
    
    @Test
    public void testGet() {
        User user = new User();
        user.setAvatar("https://realdoer.top/avatar");
        user.setEmail("1471423@qq.com");
        user.setPassword("123");
        user.setPhone("159444");
        user.setProfile("工作什么是不可能的, 代码也不会打, 只能靠偷偷电瓶车勉强维持生活");
        user.setRegisterDate(new Date(System.currentTimeMillis()));
        user.setUsername("asd");
        
        Assert.isTrue(mapper.save(user).equals(1));
        Assert.notNull(user.getUserId());
        Integer userId = user.getUserId();
        
        Assert.notNull(mapper.get(userId));
        Assert.isTrue(mapper.get(userId).getAvatar().equals("https://realdoer.top/avatar"));
    }
    
    @Test
    public void testListUser() {
        User user1 = new User();
        user1.setAvatar("https://realdoer.top/avatar");
        user1.setEmail("1471423@qq.com");
        user1.setPassword("123");
        user1.setPhone("159444");
        user1.setProfile("工作什么是不可能的, 代码也不会打, 只能靠偷偷电瓶车勉强维持生活");
        user1.setRegisterDate(new Date(System.currentTimeMillis()));
        user1.setUsername("asd");
        mapper.save(user1);
        Integer userId1 = user1.getUserId();
        
        User user2 = new User();
        user2.setAvatar("https://realdoer.top/avatar");
        user2.setEmail("1471424@qq.com");
        user2.setPassword("123");
        user2.setPhone("159445");
        user2.setProfile("工作什么是不可能的, 代码也不会打, 只能靠偷偷电瓶车勉强维持生活");
        user2.setRegisterDate(new Date(System.currentTimeMillis()));
        user2.setUsername("asd");
        mapper.save(user2);
        Integer userId2 = user2.getUserId();
        
        User user3 = new User();
        user3.setAvatar("https://realdoer.top/avatar");
        user3.setEmail("1471425@qq.com");
        user3.setPassword("123");
        user3.setPhone("159446");
        user3.setProfile("工作什么是不可能的, 代码也不会打, 只能靠偷偷电瓶车勉强维持生活");
        user3.setRegisterDate(new Date(System.currentTimeMillis()));
        user3.setUsername("asd");
        mapper.save(user3);
        Integer userId3 = user3.getUserId();
        
        List<User> users = mapper.listUser(Arrays.asList(userId1, userId2, userId3));
        Assert.isTrue(users.size() == 3);
    }
    
//    @Test
//    public void testUpdate() {
        // TODO: 写到这里了
//        User user = new User();
//        user.setUserId(1000);
////        user.setPhone("15944");
////        user.setProfile("Ah? You get mad? You get mad? You get mad?");
////        user.setRegisterDate(new Date(System.currentTimeMillis()));
////        user.setUsername("jblm");
//        user.setPassword("123456789");
//        System.out.println(mapper.update(user));
//    }
//    
//    @Test
//    public void testRemove() {
//        System.out.println(mapper.remove(1008));
//    }
//    
//    @Test
//    public void testListUser() {
//        for(User user: mapper.listUser(Arrays.asList(1000,1001,1002,1003,1004))){
//            System.out.println(user);
//        }
//    }
//    
//    @Test
//    public void testUserNameExist() {
//        Assert.isTrue(mapper.existUserName("jblm"));
//        Assert.isTrue(!mapper.existUserName("asdasdasd"));
//    }
//    
//    @Test
//    public void testEmailExist() {
//        Assert.isTrue(mapper.existEmail("1471423751@qq.com"));
//        Assert.isTrue(!mapper.existEmail("456465@outlook.com"));
//    }
//    
//    @Test
//    public void testPhoneExist() {
//        Assert.isTrue(mapper.existPhone("15944376650"));
//        Assert.isTrue(!mapper.existPhone("12345678911"));
//    }
//    
//    @Test
//    public void testUserExist() {
//        Assert.isTrue(mapper.existUser(1000));
//        Assert.isTrue(!mapper.existUser(10000));
//    }
//    
//    @Test
//    public void testGetUserByPhone() {
//        System.out.println(mapper.getUserByPhone("15944376659"));
//    }
//    
//    @Test
//    public void testGetUserByUserName() {
//        System.out.println(mapper.getUserByUserName("jblm"));
//    }
}
