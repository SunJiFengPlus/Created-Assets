package top.realdoer.dao;

import java.io.IOException;
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
import top.realdoer.constant.BrowerEnum;
import top.realdoer.dao.CompatibleBrowerMapper;

/**
 * @author 孙继峰
 * @date 2019/1/28
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class CompatibleBrowerMapperTest {
    // TODO: 边界测试
    @Autowired
    CompatibleBrowerMapper mapper;
    
    @Test
    public void testSave() throws IOException {
        mapper.save(10000, BrowerEnum.FIREFOX);
        
        List<BrowerEnum> list = mapper.list(10000);
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.contains(BrowerEnum.FIREFOX));
    }
    
    @Test
    public void testList() throws IOException {
        mapper.save(10000, BrowerEnum.FIREFOX);
        mapper.save(10000, BrowerEnum.CHROME);
        mapper.save(10000, BrowerEnum.OPERA);
        mapper.save(10000, BrowerEnum.SAFARI);
        
        List<BrowerEnum> list = mapper.list(10000);
        Assert.isTrue(list.size() == 4);
        Assert.isTrue(list.contains(BrowerEnum.FIREFOX));
        Assert.isTrue(list.contains(BrowerEnum.CHROME));
        Assert.isTrue(list.contains(BrowerEnum.OPERA));
        Assert.isTrue(list.contains(BrowerEnum.SAFARI));
    }
    
    @Test
    public void testSaveList() {
        Integer rs = mapper.saveList(10000, Arrays.asList(BrowerEnum.IE6, BrowerEnum.IE7, BrowerEnum.IE8));
        Assert.isTrue(rs.equals(3));
        List<BrowerEnum> list = mapper.list(10000);
        Assert.isTrue(list.contains(BrowerEnum.IE6));
        Assert.isTrue(list.contains(BrowerEnum.IE7));
        Assert.isTrue(list.contains(BrowerEnum.IE8));
        Assert.isTrue(!list.contains(BrowerEnum.IE9));
    }

}
