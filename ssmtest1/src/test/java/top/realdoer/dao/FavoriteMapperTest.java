package top.realdoer.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Assert;
import top.realdoer.dao.FavoriteMapper;

/**
 * @author 孙继峰
 * @date 2019年1月28日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class FavoriteMapperTest {
    // TODO: 边界测试
    @Autowired
    FavoriteMapper mapper;
    
    @Test
    public void testSave() {
        mapper.save(10000, 10001);
        
        List<Integer> list = mapper.list(10000);
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.contains(10001));
    }
    
    @Test
    public void testList() {
        mapper.save(10000, 10001);
        mapper.save(10000, 10002);
        mapper.save(10000, 10003);
        mapper.save(10000, 10004);
        mapper.save(10000, 10005);
        
        List<Integer> list = mapper.list(10000);
        Assert.isTrue(list.size() == 5);
        Assert.isTrue(list.contains(10001));
        Assert.isTrue(list.contains(10002));
        Assert.isTrue(list.contains(10003));
        Assert.isTrue(list.contains(10004));
        Assert.isTrue(list.contains(10005));
    }
    
    @Test
    public void testRemove() {
        mapper.save(10000, 10001);
        
        List<Integer> list = mapper.list(10000);
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.contains(10001));
        
        mapper.remove(10000, 10001);
        list = mapper.list(10000);
        Assert.isTrue(list.size() == 0);
    }
}
