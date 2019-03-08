package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

/**
 * @author 孙继峰
 * @date 2018/12/04
 */
public interface FeatureMapper {
    /**
     * 为项目添加多个特点, itemId 未作外键关联, 插入时需要提前验证其是否存在
     * @param itemId 项目 id
     * @param feature 特点
     * @return 返回此操作影响数据库的列数
     * @exception DataAccessException 当传入 feature 为 null 或空集合时抛出
     */
    public Integer save(@Param("itemId") Integer itemId, @Param("feature") List<String> feature)
        throws DataAccessException;
    
    /**
     * 返回一个项目下的特点集合
     * @return 返回一个项目下的特点集合, 如果项目不存在, 则返回空集合
     */
    public List<String> list(Integer itemId);
    
    /**
     * 删除一个项目的全部特点
     * @param itemId 项目 id
     * @return 影响的列
     */
    public Integer remove(Integer itemId);
}
