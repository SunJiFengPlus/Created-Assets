package top.realdoer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import top.realdoer.constant.ResultEnum;
import top.realdoer.dao.ItemMapper;
import top.realdoer.dao.UserMapper;
import top.realdoer.entity.Item;
import top.realdoer.exception.ServiceException;
import top.realdoer.query.ItemFilter;
import top.realdoer.service.ItemService;

/**
 * @author 孙继峰
 */
@Service
@Transactional(readOnly=true, rollbackFor=Exception.class)
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper mapper;
    @Autowired
    UserMapper userMapper;
    
    @Override
    public Item getItem(Integer id) throws ServiceException {
        Item item = mapper.getItem(id);
        if (item == null) {
            throw new ServiceException(ResultEnum.ITEM_DOESNT_EXIST);
        }
        return item;
    }

    @Override
    public List<Item> listPortfolio(Integer authorId, ItemFilter filter) throws ServiceException {
        if (!userMapper.existUser(authorId)) {
            throw new ServiceException(ResultEnum.USER_DOESNT_EXIST);
        }
        PageHelper.startPage(filter.getIndex(), filter.getMaxNumPerPage());
        return mapper.listPortfolio(authorId, filter);
    }

    @Override
    public void removeItem(Integer itemId, Integer opratorId) throws ServiceException {
        if (!mapper.exist(itemId)) {
            throw new ServiceException(ResultEnum.ITEM_DOESNT_EXIST);
        }
        if (!userMapper.existUser(opratorId)) {
            throw new ServiceException(ResultEnum.USER_DOESNT_EXIST);
        }
        Integer authorId = mapper.getAuthorId(itemId);
        if (!opratorId.equals(authorId)) {
            throw new ServiceException(ResultEnum.NO_AUTHORITY);
        }
        mapper.removeItem(itemId);
    }
}
