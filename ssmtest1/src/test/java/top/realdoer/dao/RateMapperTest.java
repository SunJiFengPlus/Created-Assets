package top.realdoer.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Assert;
import top.realdoer.entity.Rate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class RateMapperTest {
    // TODO: 边界测试
    @Autowired
    RateMapper rateMapper;
    
    @Test
    public void testSave() {
        rateMapper.save(10000, 10000, (byte)5);
        Rate rate = rateMapper.get(10000);
        Assert.isTrue(rate.getItemId().equals(10000));
        Assert.isTrue(rate.getRate().equals(5D));
        Assert.isTrue(rate.getRateNum().equals((short)1));
    }
    
    @Test
    public void testGet() {
        rateMapper.save(10000, 100000, (byte)5);
        rateMapper.save(10000, 100001, (byte)5);
        Rate rate = rateMapper.get(10000);
        
        Assert.isTrue(rate.getItemId().equals(10000));
        Assert.isTrue(rate.getRate().equals(5D));
        Assert.isTrue(rate.getRateNum().equals((short)2));
    }
}
