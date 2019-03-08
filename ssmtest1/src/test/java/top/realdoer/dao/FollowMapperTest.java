package top.realdoer.dao;

import java.io.IOException;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class FollowMapperTest {
    // TODO: 边界测试
    @Autowired
    FollowMapper mapper;
    
    @Test
    public void testSave() throws IOException {
        // 10001 关注了 10000
        mapper.save(10000, 10001);
        
        List<Integer> list = mapper.listFollowing(10001);
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.contains(10000));
    }
    
    /**
     *  TODO: DAO 层, 自己可以关注自己, 需要在业务层解决此问题
     */
    @Test
    public void testSave2() throws IOException {
        mapper.save(10000, 10000);
        
        List<Integer> list = mapper.listFollowing(10000);
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.contains(10000));
    }
    
    @Test
    public void testListFollower() throws IOException {
        // 10001 关注了 10000
        mapper.save(10000, 10001);
        mapper.save(10000, 10002);
        mapper.save(10000, 10003);
        mapper.save(10000, 10004);
        mapper.save(10000, 10005);
        
        List<Integer> list = mapper.listFollower(10000);
        Assert.isTrue(list.size() == 5);
        Assert.isTrue(list.contains(10001));
        Assert.isTrue(list.contains(10002));
        Assert.isTrue(list.contains(10003));
        Assert.isTrue(list.contains(10004));
        Assert.isTrue(list.contains(10005));
    }
    
    @Test
    public void testListFollowing() throws IOException {
        // 10001 关注了 10000
        mapper.save(10000, 10001);
        mapper.save(10002, 10001);
        mapper.save(10003, 10001);
        mapper.save(10004, 10001);
        mapper.save(10005, 10001);
        
        List<Integer> list = mapper.listFollowing(10001);
        Assert.isTrue(list.size() == 5);
        Assert.isTrue(list.contains(10000));
        Assert.isTrue(list.contains(10002));
        Assert.isTrue(list.contains(10003));
        Assert.isTrue(list.contains(10004));
        Assert.isTrue(list.contains(10005));
    }
    
    @Test
    public void testRemove() throws IOException {
        // 10001 关注了 10000
        mapper.save(10000, 10001);
        // 10001 取关 1000
        mapper.remove(10001, 10000);
        
        List<Integer> list = mapper.listFollowing(10001);
        Assert.isTrue(list.size() == 0);
    }
}
