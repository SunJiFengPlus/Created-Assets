package top.realdoer.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import io.jsonwebtoken.Claims;
import top.realdoer.constant.ResultEnum;
import top.realdoer.dto.Result;
import top.realdoer.entity.Item;
import top.realdoer.query.ItemFilter;
import top.realdoer.service.ItemService;
import top.realdoer.util.JWTUtil;

/**
 * 项目 Controller, 用于处理没有指定项目类型项目的请求
 * 由于没有写鉴权拦截器, 鉴权处理需要放在第一行. 原因: 鉴权拦截器会解析鉴权信息, 在目标方法中也会检查鉴权信息,
 * 两次鉴权检查操作影响效率, 且在拦截器中鉴权出的异常不会被全局异常处理器处理
 *  
 * @author 孙继峰 
 * @date 2018/12/05
 */
// TODO: Interceptor 参数合法验证
// TODO: AOP: 日志
// TODO: 异步编程
// TODO: 限流
// TODO: REST API 设计
// TODO: 设计异常 如果与业务功能相关的异常，建议在service中抛出异常。  与业务功能没有关系的异常，建议在controller中抛出。
// TODO: 权限收束 能 private 就不 public 
@RestController
@PropertySource("classpath:properties/server.properties")
public class ItemController {
    @Autowired
    ItemService service;
    
    /**
     *  服务器地址
     */
    @Value("${address}")
    private String address;
    
    /**
     *  临时文件夹位置
     */
    @Value("${temp_dir}")
    private String serverTempPath;
    
    /**
     * 使用默认的端口号
     */
    @Value("${use_default_port}")
    private Boolean useDefaultPort;
    
    /**
     * 分页返回作者上传的项目集合
     * @param authorId 作者 id
     * @return 返回作者上传项目集合的数据传输对象
     */
    @GetMapping("/portfolio/{authorId}")
    public Result listPortfolio(@PathVariable("authorId") Integer authorId, ItemFilter filter) throws Exception {
        List<Item> items = service.listPortfolio(authorId, filter);
        int[] navigatePages = new PageInfo<>(items, filter.getMaxNumPerPage()).getNavigatepageNums();
        
        return new Result.Builder()
                .buildData(items)
                .buildCurrentIndex(filter.getIndex())
                .buildNavigatePages(navigatePages)
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }

    /**
     * 不指定项目类型时, 返回一个项目
     * @param itemId 项目 id
     * @return 返回一个项目
     */
    @GetMapping("/item/{itemId}")
    public Result getItem(@PathVariable("itemId") Integer itemId) throws Exception {
        Item item = service.getItem(itemId);
        
        return new Result.Builder()
                .buildData(item)
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }

    /**
     * 用户上传临时文件
     * TODO: 项目存放位置更改, 需要改目录
     * @param file 上传的文件
     * @return 文件在服务器中的临时地址
     */
    @PostMapping("/upload")
    public Result uploadHtmlTemplate(MultipartFile file, HttpServletRequest request) throws Exception {
        String userId = (String)JWTUtil.getPayloadDetail(request, Claims.ID);
        // 文件名: asdasd.png
        String simpleFileName = file.getOriginalFilename();
        // 后缀名: .png
        String suffix = simpleFileName.substring(simpleFileName.lastIndexOf('.'));
        // 目标目录: F:\workspace\.metadata\.me_tcat85\webapps\ssmtest1\WEB-INF\temp\{userId}
        File destDir = new File(request.getServletContext().getRealPath(serverTempPath + "/" + userId + "/"));
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        // 1547797152242
        String uploadDate = String.valueOf(System.currentTimeMillis());
        // 全文件名: F:\workspace\.metadata\.me_tcat85\webapps\ssmtest1\WEB-INF\temp\{userId}\1547797152242.png
        File fullFileName = new File(destDir + "/" + uploadDate + suffix);
        file.transferTo(fullFileName);
        
        // 服务器地址路径: https://realdoer.top/ssmtest1/WEB-INF/temp/{userId}/1547797152242.png
        StringBuffer serverPathBuilder = new StringBuffer(request.getScheme())
                .append("://").append(address)
                .append(useDefaultPort ? "" : ":" + request.getServerPort())
                .append(request.getContextPath())
                .append(serverTempPath).append("/")
                .append(uploadDate).append(suffix);

        return new Result.Builder()
                .buildPath(serverPathBuilder.toString())
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
    
    /**
     * 删除项目
     * @param itemId 项目 id
     * @return 执行结果
     */
    @DeleteMapping("/item/{itemId}")
    public Result deleteItem(@PathVariable("itemId") Integer itemId, HttpServletRequest request) throws Exception {
        // TODO: Object 强转 Integer 会抛类型转换异常??? 还需要先转换为 String 再转 Integer???
        String id = (String) JWTUtil.getPayloadDetail(request, Claims.ID);
        Integer userId = Integer.valueOf(id);
        service.removeItem(itemId, userId);
        
        return new Result.Builder()
                .buildResult(ResultEnum.SUCCESS)
                .build();
    }
}

/*
 *          ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 *          ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐░     问  题  C  O  D  E
 *          ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░     
 *          ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░     T  O  D  O  过  多
 *          ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░     
 *          ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒░     女   人    唱    歌    男   人    改    B  U  G
 *          ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐     
 *          ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄     希   望    の    花
 *          ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 *          ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒     开   发    屑  (wwwwwwwww
 */
