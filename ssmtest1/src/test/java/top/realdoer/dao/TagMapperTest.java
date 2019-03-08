package top.realdoer.dao;

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
import top.realdoer.dao.TagMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class TagMapperTest {
    // TODO: 边界测试
    @Autowired
    TagMapper tagMapper;
    
    @Test
    public void testSave() {
        Integer rs = tagMapper.save(10000, "testtag");
        Assert.isTrue(rs.equals(1));
    }
    
    @Test
    public void testSaveList() {
        Integer rs = tagMapper.saveList(10000, Arrays.asList("1","2","3"));
        Assert.isTrue(rs.equals(3));
    }
    
    @Test
    public void testList() {
        Integer rs = tagMapper.saveList(10000, Arrays.asList("1","2","3"));
        Assert.isTrue(rs.equals(3));
        
        List<String> list = tagMapper.list(10000);
        Assert.isTrue(list.size() == 3);
        Assert.isTrue(list.contains("1"));
        Assert.isTrue(list.contains("2"));
        Assert.isTrue(list.contains("3"));
    }
}