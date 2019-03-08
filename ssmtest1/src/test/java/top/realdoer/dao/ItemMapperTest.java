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
import top.realdoer.constant.ItemType;
import top.realdoer.entity.Item;
import top.realdoer.entity.TemplateHtml;
import top.realdoer.query.ItemFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class ItemMapperTest {
    // TODO: 边界测试
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    TemplateHtmlMapper htmlMapper;
    
    @Test
    public void testGetItem() {
        TemplateHtml webTemplate = new TemplateHtml();
        webTemplate.setAuthorId(10000);
        webTemplate.setDescription("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>");
        webTemplate.setExtendedLicensePrice((short)500);
        webTemplate.setRegularLicensePrice((short)37);
        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
        webTemplate.setPreview("htpps://realdoer.top/preview");
        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
        webTemplate.setTitle("普通的 title, 我们普通的看");
        webTemplate.setType(ItemType.TEMPLATE_HTML);
        htmlMapper.save(webTemplate);
        
        Assert.notNull(webTemplate.getItemId());
        Item item = itemMapper.getItem(webTemplate.getItemId());
        Assert.isTrue(item.getAuthorId().equals(10000));
        Assert.isTrue(item.getDescription().equals("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>"));
        Assert.isTrue(item.getExtendedLicensePrice().equals((short)500));
        Assert.isTrue(item.getRegularLicensePrice().equals((short)37));
        Assert.isTrue(item.getMainFile().equals("htpps://realdoer.top/mainFile"));
        Assert.isTrue(item.getPreview().equals("htpps://realdoer.top/preview"));
        Assert.isTrue(item.getType().equals(ItemType.TEMPLATE_HTML));
    }
    
    @Test
    public void testListPortfolio() {
        // TODO: 咕咕咕
//        ItemFilter filter = new ItemFilter();
//        filter.setIndex(2);
//        filter.setMaxNumPerPage(4);
//        List<Item> items = itemMapper.listPortfolio(10000, filter);
//        Assert.notEmpty(items);
//        for (Item item : items) {
//            System.out.println(item);
//        }
    }
    
    @Test
    public void testListItem() {
        TemplateHtml webTemplate = new TemplateHtml();
        webTemplate.setAuthorId(10000);
        webTemplate.setDescription("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>");
        webTemplate.setExtendedLicensePrice((short)500);
        webTemplate.setRegularLicensePrice((short)37);
        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
        webTemplate.setPreview("htpps://realdoer.top/preview");
        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
        webTemplate.setTitle("普通的 title, 我们普通的看");
        webTemplate.setType(ItemType.TEMPLATE_HTML);
        htmlMapper.save(webTemplate);
        Assert.notNull(webTemplate.getItemId());
        
        List<Item> items = itemMapper.listItem(Arrays.asList(webTemplate.getItemId()));
        Assert.notNull(items);
        Assert.isTrue(items.size() == 1);
    }
    
    @Test
    public void testGetAuthorId() {
        TemplateHtml webTemplate = new TemplateHtml();
        webTemplate.setAuthorId(10000);
        webTemplate.setDescription("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>");
        webTemplate.setExtendedLicensePrice((short)500);
        webTemplate.setRegularLicensePrice((short)37);
        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
        webTemplate.setPreview("htpps://realdoer.top/preview");
        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
        webTemplate.setTitle("普通的 title, 我们普通的看");
        webTemplate.setType(ItemType.TEMPLATE_HTML);
        htmlMapper.save(webTemplate);
        Assert.notNull(webTemplate.getItemId());
        
        Assert.isTrue(itemMapper.getAuthorId(webTemplate.getItemId()).equals(10000));
    }
    
    @Test
    public void testExist() {
        TemplateHtml webTemplate = new TemplateHtml();
        webTemplate.setAuthorId(10000);
        webTemplate.setDescription("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>");
        webTemplate.setExtendedLicensePrice((short)500);
        webTemplate.setRegularLicensePrice((short)37);
        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
        webTemplate.setPreview("htpps://realdoer.top/preview");
        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
        webTemplate.setTitle("普通的 title, 我们普通的看");
        webTemplate.setType(ItemType.TEMPLATE_HTML);
        htmlMapper.save(webTemplate);
        Assert.notNull(webTemplate.getItemId());
        
        Assert.isTrue(itemMapper.exist(webTemplate.getItemId()));
        Assert.isTrue(!itemMapper.exist(984984));
    }
}
