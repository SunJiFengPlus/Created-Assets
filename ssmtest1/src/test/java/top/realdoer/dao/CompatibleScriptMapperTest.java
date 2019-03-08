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
import top.realdoer.constant.ScriptEnum;
import top.realdoer.dao.CompatibleScriptMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class CompatibleScriptMapperTest {
    // TODO: 边界测试
    @Autowired
    CompatibleScriptMapper mapper;
    
    @Test
    public void testSave() throws IOException {
        mapper.save(10000, ScriptEnum.ANGULARJS);
        List<ScriptEnum> list = mapper.list(10000);
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.contains(ScriptEnum.ANGULARJS));
    }
    
    @Test
    public void testList() throws IOException {
        mapper.save(10000, ScriptEnum.ANGULARJS);
        mapper.save(10000, ScriptEnum.BOOTSTRAP4);
        mapper.save(10000, ScriptEnum.ECWID);
        mapper.save(10000, ScriptEnum.FACEBOOK);
        mapper.save(10000, ScriptEnum.FOUNDATION6);
        
        List<ScriptEnum> list = mapper.list(10000);
        Assert.isTrue(list.size() == 5);
        Assert.isTrue(list.contains(ScriptEnum.ANGULARJS));
        Assert.isTrue(list.contains(ScriptEnum.BOOTSTRAP4));
        Assert.isTrue(list.contains(ScriptEnum.ECWID));
        Assert.isTrue(list.contains(ScriptEnum.FACEBOOK));
        Assert.isTrue(list.contains(ScriptEnum.FOUNDATION6));
    }
    
    @Test
    public void testSaveList() {
        Integer rs = mapper.saveList(10000, Arrays.asList(ScriptEnum.ANGULARJS2, ScriptEnum.ANGULARJS3, 
                ScriptEnum.ANGULARJS4));
        Assert.isTrue(rs.equals(3));
        List<ScriptEnum> list = mapper.list(10000);
        Assert.isTrue(list.size() == 3);
        Assert.isTrue(list.contains(ScriptEnum.ANGULARJS2));
        Assert.isTrue(list.contains(ScriptEnum.ANGULARJS3));
        Assert.isTrue(list.contains(ScriptEnum.ANGULARJS4));
    }
}
