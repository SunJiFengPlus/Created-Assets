package top.realdoer.dao;

import org.apache.ibatis.annotations.Param;

import top.realdoer.entity.Rate;

/**
 *  项目得分
 */
public interface RateMapper {
    
    /**
     * 返回一个项目的得分信息, 当项目不存在或项目没有任何评价信息, 则返回 Rate(itemId=null, rate=null, rateNum=0)
     * @param itemId 项目 id
     * @return 返回一个项目的得分
     */
    public Rate get(Integer itemId);
    
    /**
     * 添加一个项目得分, 评分 1-5, 项目不存在时也能插入, 需要提前判断
     * @param itemId 项目 id
     * @param userId 用户 id
     * @param rate 项目得分
     * @return 返回此操作影响数据库的列数
     */
    public Integer save(@Param("itemId") Integer itemId, @Param("userId") Integer userId,
                        @Param("rate") Byte rate);
}
