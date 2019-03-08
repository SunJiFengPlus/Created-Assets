package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 *  标签
 */
public interface TagMapper {
    /**
     * 为项目添加一个标签, itemId 与 tag 都不能为 null, 否则抛异常
     * @param itemId 项目 id
     * @param tag 标签内容
     * @return 返回此操作影响数据库的列数
     */
    public Integer save(@Param("itemId") Integer itemId, @Param("tag") String tag);
    
    /**
     * 为项目添加多个标签, itemId 与 tags 都不能为 null, 且 tags 不能为空集合, 否则抛异常
     * @param itemId 项目 id
     * @param tag 标签集合
     * @return 返回此操作影响数据库的列数
     */
    public Integer saveList(@Param("itemId") Integer itemId, @Param("tags") List<String> tags);
    
    /**
     * 列出一个项目下的标签集合, 当项目不存在时返回空集合
     * @param itemId
     * @return 列出一个项目下的标签集合
     */
    public List<String> list(Integer itemId);
}
