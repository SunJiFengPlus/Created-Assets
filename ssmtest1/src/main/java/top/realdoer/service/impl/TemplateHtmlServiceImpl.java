package top.realdoer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import top.realdoer.constant.ResultEnum;
import top.realdoer.dao.CompatibleBrowerMapper;
import top.realdoer.dao.CompatibleScriptMapper;
import top.realdoer.dao.FeatureMapper;
import top.realdoer.dao.FileIncludeMapper;
import top.realdoer.dao.ItemMapper;
import top.realdoer.dao.TagMapper;
import top.realdoer.dao.TemplateHtmlMapper;
import top.realdoer.entity.TemplateHtml;
import top.realdoer.exception.ServiceException;
import top.realdoer.query.ItemFilter;
import top.realdoer.service.TemplateHtmlService;

/**
 * @author 孙继峰
 * @date 2018/12/01
 */
@Service
public class TemplateHtmlServiceImpl implements TemplateHtmlService {
    @Autowired
    TemplateHtmlMapper mapper;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    FeatureMapper featureMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    FileIncludeMapper fileIncludeMapper;
    @Autowired
    CompatibleBrowerMapper compatibleBrowerMapper;
    @Autowired
    CompatibleScriptMapper compatibleScriptMapper;
    
    @Override
    public TemplateHtml getById(Integer pk) throws ServiceException {
        TemplateHtml templateHtml = mapper.get(pk);
        if (templateHtml == null) {
            throw new ServiceException(ResultEnum.ITEM_DOESNT_EXIST);
        }
        return templateHtml;
    }

    @Override
    public Integer save(TemplateHtml t) throws ServiceException {
        Integer affect = mapper.save(t); 
        Integer pk = t.getItemId();
        featureMapper.save(pk, t.getFeature());
        tagMapper.saveList(pk, t.getTag());
        fileIncludeMapper.saveList(pk, t.getFileInclude());
        compatibleBrowerMapper.saveList(pk, t.getCompatibleBrower());
        compatibleScriptMapper.saveList(pk, t.getCompatibleScript());
        return affect;
    }
    
    @Override
    public Integer removeById(Integer pk, Integer opratorId) throws ServiceException {
        Integer authorId = itemMapper.getAuthorId(pk);
        if (!opratorId.equals(authorId)) {
            throw new ServiceException(ResultEnum.NO_AUTHORITY);
        }
        return mapper.remove(pk);
    }

    @Override
    public Integer update(TemplateHtml t, Integer opratorId) throws ServiceException {
        Integer authorId = itemMapper.getAuthorId(t.getItemId());
        if (!opratorId.equals(authorId)) {
            throw new ServiceException(ResultEnum.NO_AUTHORITY);
        }
        return mapper.update(t);
    }
    
    @Override
    public List<TemplateHtml> listByFilter(ItemFilter filter) throws ServiceException {
        PageHelper.startPage(filter.getIndex(), filter.getMaxNumPerPage());
        return mapper.listByFilter(filter);
    }
}
