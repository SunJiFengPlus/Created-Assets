package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.realdoer.constant.FileTypeEnum;

/**
 *  文件包含
 */
public interface FileIncludeMapper {
    /**
     *  添加一个文件类型, itemId 未作外键关联, 需要提前验证
     *  @param itemId 项目 id
     *  @param fileType 文件类型的枚举值
     *  @return 返回此操作影响数据库的列数
     */
    public Integer save(@Param("itemId") Integer itemId, @Param("fileType") FileTypeEnum fileType);
    
    /**
     * 添加一个文件类型集合, itemId 未作外键关联, 需要提前验证
     * @param itemId 项目 id
     * @param fileTypes 文件类型集合
     * @return 返回此操作影响数据库的列数
     */
    public Integer saveList(@Param("itemId") Integer itemId, @Param("fileTypes") List<FileTypeEnum> fileTypes);
    
    /**
     * 返回一个项目中包含的文件类型集合
     * @param itemId 项目 id
     * @return 返回一个项目中包含的文件类型集合, 如果项目不存在或项目没有对应的文件类型, 则返回空集合
     */
    public List<FileTypeEnum> list(Integer itemId);
}
