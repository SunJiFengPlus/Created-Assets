package top.realdoer.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Assert;
import top.realdoer.constant.ItemType;
import top.realdoer.entity.TemplateHtml;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Rollback
@Transactional
public class TemplateHtmlMapperTest {
    // TODO: 边界测试
    @Autowired
    TemplateHtmlMapper templateHtmlMapper;
    
    @Test
    public void testSave() {
        TemplateHtml webTemplate = new TemplateHtml();
        webTemplate.setAuthorId(1001);
        webTemplate.setDescription("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>");
        webTemplate.setExtendedLicensePrice((short)500);
        webTemplate.setRegularLicensePrice((short)37);
        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
        webTemplate.setPreview("htpps://realdoer.top/preview");
        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
        webTemplate.setTitle("普通的 title, 我们普通的看");
        webTemplate.setDemoUrl("htpps://realdoer.top/demo");
        webTemplate.setType(ItemType.TEMPLATE_HTML);
        
        Integer rs = templateHtmlMapper.save(webTemplate);
        Assert.isTrue(rs.equals(1));
        Assert.notNull(webTemplate.getItemId());
    }
    
    @Test
    public void testRemove() {
        TemplateHtml webTemplate = new TemplateHtml();
        webTemplate.setAuthorId(1001);
        webTemplate.setDescription("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>");
        webTemplate.setExtendedLicensePrice((short)500);
        webTemplate.setRegularLicensePrice((short)37);
        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
        webTemplate.setPreview("htpps://realdoer.top/preview");
        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
        webTemplate.setTitle("普通的 title, 我们普通的看");
        webTemplate.setDemoUrl("htpps://realdoer.top/demo");
        webTemplate.setType(ItemType.TEMPLATE_HTML);
        
        Integer rs = templateHtmlMapper.save(webTemplate);
        Integer itemId = webTemplate.getItemId();
        Assert.isTrue(rs.equals(1));
        Assert.notNull(itemId);
        
        Integer rs2 = templateHtmlMapper.remove(itemId);
        Assert.isTrue(rs2.equals(1));
        Assert.isNull(templateHtmlMapper.get(itemId));
    }
    
    @Test
    public void testUpdate() {
        TemplateHtml webTemplate = new TemplateHtml();
        webTemplate.setAuthorId(1001);
        webTemplate.setDescription("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>");
        webTemplate.setExtendedLicensePrice((short)500);
        webTemplate.setRegularLicensePrice((short)37);
        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
        webTemplate.setPreview("htpps://realdoer.top/preview");
        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
        webTemplate.setTitle("普通的 title, 我们普通的看");
        webTemplate.setDemoUrl("htpps://realdoer.top/demo");
        webTemplate.setType(ItemType.TEMPLATE_HTML);
        
        Integer rs = templateHtmlMapper.save(webTemplate);
        Integer itemId = webTemplate.getItemId();
        Assert.isTrue(rs.equals(1));
        Assert.notNull(itemId);
        
        
        TemplateHtml webTemplate2 = new TemplateHtml();
        webTemplate2.setItemId(itemId);
        webTemplate2.setDescription("testDescription");
        Assert.isTrue(templateHtmlMapper.update(webTemplate2).equals(1));
        System.out.println(templateHtmlMapper.get(itemId));
        Assert.isTrue(templateHtmlMapper.get(itemId).getDescription().equals("testDescription"));
    }
    
    @Test
    public void testGet() {
        TemplateHtml webTemplate = new TemplateHtml();
        webTemplate.setAuthorId(1001);
        webTemplate.setDescription("asdasd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>");
        webTemplate.setExtendedLicensePrice((short)500);
        webTemplate.setRegularLicensePrice((short)37);
        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
        webTemplate.setPreview("htpps://realdoer.top/preview");
        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
        webTemplate.setTitle("普通的 title, 我们普通的看");
        webTemplate.setDemoUrl("htpps://realdoer.top/demo");
        webTemplate.setType(ItemType.TEMPLATE_HTML);
        
        Integer rs = templateHtmlMapper.save(webTemplate);
        Integer itemId = webTemplate.getItemId();
        Assert.isTrue(rs.equals(1));
        Assert.notNull(itemId);
        
        Assert.notNull(templateHtmlMapper.get(itemId));
        Assert.isTrue(templateHtmlMapper.get(itemId).getAuthorId().equals(1001));
        Assert.isTrue(templateHtmlMapper.get(itemId).getType().equals(ItemType.TEMPLATE_HTML));
    }
    
    @Test
    public void testListByFilter() {
        // TODO: 咕咕咕
//        ItemFilter filter = new ItemFilter();
//        filter.setSortBy(ItemField.REGULAR_LICENSE_PRICE);
//        List<TemplateHtml> list = templateHtmlMapper.listByFilter(filter);
//        for (TemplateHtml templateHtml : list) {
//            System.out.println(templateHtml);
//        }
    }
    
    @Test
    public void testGetAuthorId() {
//        templateHtmlMapper.getAuthorId(1029);
    }
}
