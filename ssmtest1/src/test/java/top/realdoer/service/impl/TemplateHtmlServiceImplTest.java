package top.realdoer.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.realdoer.constant.BrowerEnum;
import top.realdoer.constant.FileTypeEnum;
import top.realdoer.constant.ItemField;
import top.realdoer.constant.ItemType;
import top.realdoer.constant.ScriptEnum;
import top.realdoer.entity.TemplateHtml;
import top.realdoer.exception.ServiceException;
import top.realdoer.query.ItemFilter;
import top.realdoer.service.TemplateHtmlService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class TemplateHtmlServiceImplTest {
    // TODO: 测试类 AIR 原则
    // https://github.com/alibaba/fastjson/blob/master/src/test/java/com/alibaba/fastjson/parser/JSONScannerTest.java
    @Autowired
    TemplateHtmlService service;
    
    @Test
    public void testSave1() throws ServiceException {
//        TemplateHtml webTemplate = new TemplateHtml();
//        webTemplate.setAuthorId(1001);
//        webTemplate.setDescription("asdasdd<h1>这是一个带html解析的描述, 但是还没写 XSS 过滤</h1>asdasdd");
//        webTemplate.setExtendedLicensePrice((short)600);
//        webTemplate.setRegularLicensePrice((short)66);
//        webTemplate.setMainFile("htpps://realdoer.top/mainFile");
//        webTemplate.setPreview("htpps://realdoer.top/preview");
//        webTemplate.setThumbnail("htpps://realdoer.top/thumbnail");
//        webTemplate.setTitle("普通的 title, 我们普通的看");
//        webTemplate.setDemoUrl("htpps://realdoer.top/demo");
//        webTemplate.setCompatibleBrower(Arrays.asList(BrowerEnum.FIREFOX, BrowerEnum.EDGE, BrowerEnum.CHROME));
//        webTemplate.setCompatibleScript(Arrays.asList(ScriptEnum.ANGULARJS, ScriptEnum.ANGULARJS2, ScriptEnum.FACEBOOK));
//        webTemplate.setFeature(Arrays.asList("为", "维", "威"));
//        webTemplate.setFileInclude(Arrays.asList(FileTypeEnum.AE_PROJECT, FileTypeEnum.CSS, FileTypeEnum.HTML));
//        webTemplate.setTag(Arrays.asList("tag1","tag2","tag3"));
//        webTemplate.setType(ItemType.TEMPLATE_HTML);
//        service.save(webTemplate);
//        System.out.println(webTemplate);
    }
    
    @Test
    public void testGetById() throws ServiceException {
//        System.out.println(service.getById(1000));
    }
    
    @Test
    public void testRemoveById() throws ServiceException {
//        System.out.println(service.removeById(1027, 1001));
    }
    
    @Test
    public void testUpdate() throws ServiceException {
//        TemplateHtml t = new TemplateHtml();
//        t.setItemId(1025);
//        t.setAuthorId(1000);
//        t.setTitle("这个 title 不普通");
//        System.out.println(service.update(t, 1000));
    }
    
    @Test
    public void testListByFilter() throws ServiceException {
//        ItemFilter filter = new ItemFilter();
//        filter.setSortBy(ItemField.REGULAR_LICENSE_PRICE);
//        List<TemplateHtml> list = service.listByFilter(filter);
//        for (TemplateHtml templateHtml : list) {
//            System.out.println(templateHtml);
//        }
    }
}
