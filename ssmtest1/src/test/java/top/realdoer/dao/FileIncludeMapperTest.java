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
import top.realdoer.constant.FileTypeEnum;
import top.realdoer.dao.FileIncludeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class FileIncludeMapperTest {
    // TODO: 边界测试
    @Autowired
    FileIncludeMapper mapper;
    
    @Test
    public void testSave() {
        mapper.save(10000, FileTypeEnum.HTML);
        
        List<FileTypeEnum> list = mapper.list(10000);
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.get(0).equals(FileTypeEnum.HTML));
    }
    
    @Test
    public void testSaveList() {
        mapper.saveList(10000, Arrays.asList(FileTypeEnum.AE_PROJECT, FileTypeEnum.CSS, FileTypeEnum.IMAGE));
        
        List<FileTypeEnum> list = mapper.list(10000);
        Assert.isTrue(list.size() == 3);
        Assert.isTrue(list.contains(FileTypeEnum.AE_PROJECT));
        Assert.isTrue(list.contains(FileTypeEnum.CSS));
        Assert.isTrue(list.contains(FileTypeEnum.IMAGE));
    }
    
    @Test
    public void testList() {
        mapper.save(10000, FileTypeEnum.HTML);
        mapper.save(10000, FileTypeEnum.CSS);
        mapper.save(10000, FileTypeEnum.JS);
        mapper.save(10000, FileTypeEnum.JSP);
        mapper.save(10000, FileTypeEnum.LAYERED_PSD);
        
        List<FileTypeEnum> list = mapper.list(10000);
        Assert.isTrue(list.size() == 5);
        Assert.isTrue(list.contains(FileTypeEnum.HTML));
        Assert.isTrue(list.contains(FileTypeEnum.CSS));
        Assert.isTrue(list.contains(FileTypeEnum.JS));
        Assert.isTrue(list.contains(FileTypeEnum.JSP));
        Assert.isTrue(list.contains(FileTypeEnum.LAYERED_PSD));
    }
}
