package top.realdoer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import io.jsonwebtoken.Claims;
import top.realdoer.constant.ResultEnum;
import top.realdoer.dto.Result;
import top.realdoer.entity.TemplateHtml;
import top.realdoer.exception.AuthorizationException;
import top.realdoer.exception.ServiceException;
import top.realdoer.query.ItemFilter;
import top.realdoer.service.TemplateHtmlService;
import top.realdoer.util.JWTUtil;

/**
 * @author 孙继峰
 * @date 2018/12/07
 */
@RestController
public class TemplateHtmlController {
    
    @Autowired
    TemplateHtmlService service;
    
    /**
     * 上传项目
     * @param item
     * @param request
     * @throws AuthorizationException
     */
    @PostMapping("/htmlTemplate")
    public void saveHtmlTemplate(TemplateHtml item, HttpServletRequest request)
            throws ServiceException, AuthorizationException {
        // TODO: Object 强转 Integer 会抛类型转换异常???
//      Integer userId = (Integer) JWTUtil.getPayloadDetail(request, Claims.ID);
        String id = (String) JWTUtil.getPayloadDetail(request, Claims.ID);
        Integer userId = Integer.valueOf(id);
        item.setAuthorId(userId);
        service.save(item);
        // TODO: 异步的将临时目录中的文件移动到持久文件夹中
    }
    
    /**
     * 用户更新自己的项目
     * @param item
     * @param request
     * @throws AuthorizationException
     * @throws Exception 
     */
    @PutMapping("/htmlTemplate")
    public void updateTemplateHtml(TemplateHtml item, HttpServletRequest request)
            throws ServiceException, AuthorizationException {
        // TODO: Object 强转 Integer 会抛类型转换异常???
        String id = (String) JWTUtil.getPayloadDetail(request, Claims.ID);
        Integer userId = Integer.valueOf(id);
        item.setAuthorId(userId);
        service.update(item, userId);
    }
    
    /**
     * 分页返回网站模板项目
     * @param filter 过滤参数
     * @return 返回分页后网站模板项目的数据传输对象
     * @throws Exception 
     */
    @PostMapping("/htmlTemplates")
    public Result listTemplateHtml(ItemFilter filter) throws ServiceException {
        List<TemplateHtml> items = service.listByFilter(filter);
        int[] navigatePages = new PageInfo<TemplateHtml>(items, filter.getMaxNumPerPage()).getNavigatepageNums();
        
        return new Result.Builder()
                .buildData(items)
                .buildCurrentIndex(filter.getIndex())
                .buildNavigatePages(navigatePages)
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }

    /**
     * 根据 id 返回网站模板
     * @param itemId
     * @return
     * @throws ServiceException
     */
    @GetMapping("/htmlTemplate/{itemId}")
    public Result getTemplateHtmlById(@PathVariable("itemId") Integer itemId) throws ServiceException {
        TemplateHtml item = service.getById(itemId);
        
        return new Result.Builder()
                .buildData(item)
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
}