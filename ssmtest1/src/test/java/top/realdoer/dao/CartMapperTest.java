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
import top.realdoer.dao.CartMapper;

/**
 * @author 孙继峰
 * @date 2018/12/01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Transactional
@Rollback
public class CartMapperTest {
    // TODO: 边界测试
    @Autowired
    CartMapper cartMapper;
    
    @Test
    public void testSave() throws IOException {
        cartMapper.save(10000,10000);
        List<Integer> list = cartMapper.list(10000);
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.get(0) == 10000);
    }
    
    @Test
    public void testCount() throws IOException {
        System.out.println(cartMapper.count(1002));
    }
    
    @Test
    public void testList() throws IOException {
        List<Integer> items = cartMapper.list(1002);
        System.out.println(items);
    }
    
    @Test
    public void testRemove() throws IOException {
        cartMapper.save(10000,10000);
        cartMapper.remove(10000, 10000);
        List<Integer> list = cartMapper.list(10000);
        Assert.isTrue(list.size() == 0);
    }
    
    @Test
    public void testRemoveAll() throws IOException {
        cartMapper.save(10000,10000);
        cartMapper.save(10000,10001);
        cartMapper.save(10000,10002);
        cartMapper.save(10000,10003);
        cartMapper.save(10000,10004);
        cartMapper.removeAll(10000);
        List<Integer> list = cartMapper.list(10000);
        Assert.isTrue(list.size() == 0);
    }
}
