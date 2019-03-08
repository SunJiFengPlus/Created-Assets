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
import top.realdoer.dao.FeatureMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class FeatureMapperTest {
    // TODO: 边界测试
    @Autowired
    FeatureMapper mapper;
    
    @Test
    public void testSave1() {
        List<String> feature = Arrays.asList("10000Feature", "10000特色", "经过 XSS 过滤后发给后台");
        mapper.save(10000, feature);
        
        List<String> list = mapper.list(10000);
        Assert.isTrue(list.size() == 3);
        Assert.isTrue(list.contains("10000Feature"));
        Assert.isTrue(list.contains("10000特色"));
        Assert.isTrue(list.contains("经过 XSS 过滤后发给后台"));
    }
    
//    @Test
//    public void testSave2() {
//        List<String> feature = Arrays.asList();
//        System.out.println(mapper.save(1002, feature));
//    }
//    
//    @Test
//    public void testSave3() {
//        System.out.println(mapper.save(1002, null));
//    }
    
    @Test
    public void testList() {
        List<String> feature = Arrays.asList("10000Feature", "10000特色", "经过 XSS 过滤后发给后台");
        mapper.save(10000, feature);
        
        List<String> list = mapper.list(10000);
        Assert.isTrue(list.size() == 3);
        Assert.isTrue(list.contains("10000Feature"));
        Assert.isTrue(list.contains("10000特色"));
        Assert.isTrue(list.contains("经过 XSS 过滤后发给后台"));
    }
    
    @Test
    public void testRemove() {
        List<String> feature = Arrays.asList("10000Feature", "10000特色", "经过 XSS 过滤后发给后台");
        mapper.save(10000, feature);
        mapper.remove(10000);
        
        List<String> list = mapper.list(10000);
        Assert.isTrue(list.size() == 0);
    }
}
