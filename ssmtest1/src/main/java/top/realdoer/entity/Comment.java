package top.realdoer.entity;

import java.sql.Date;

import lombok.Data;

/**
 *  服务端评论模型 
 */
@Data
public class Comment {
    // 评论 id
    private Integer commentId;
    // 项目 id
    private Integer itemId;
    // 用户 id
    private Integer userId;
    // 父评论 id
    private Integer parentId;
    // 评论内容 varchar(1000)
    private String content;
    // 评论日期
    private Date date;
}
