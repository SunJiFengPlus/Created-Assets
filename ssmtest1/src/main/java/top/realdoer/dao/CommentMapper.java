package top.realdoer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.realdoer.entity.Comment;

/**
 * @author 孙继峰
 * @date 2018/12/02
 */
public interface CommentMapper {
    // TODO: trigger 保存评论时把用户头像 用户名加到表中
    
    /**
     * 在项目中添加一条评论
     * @param comment 评论
     * @return 返回此操作影响数据库的列数
     */
    public Integer save(Comment comment);
    
    /**
     * 返回一个项目对应的评论集合
     * @param itemId 项目 id
     * @return 返回一个项目对应的评论集合
     */
    public List<Comment> list(Integer itemId);
    
    /**
     * 返回一个项目评论的数量
     * @param itemId 项目 id
     * @return 返回一个项目下评论的数量
     */
    public Integer count(Integer itemId);
    
    /**
     * 移除一个的评论
     * @param commentId 评论 id
     * @return 影响的列
     */
    public Integer remove(Integer commentId);
    
    /**
     * 判断此评论是否由此用户发表
     * @param commentId 评论 id
     * @param userId 用户 id
     * @return 当前评论是由此用户发表时返回 true, 否则返回 false, 当 commentId 不存在时返回 null
     */
    public Boolean checkBelong(@Param("commentId") Integer commentId, @Param("userId") Integer userId);
}
